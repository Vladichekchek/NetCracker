package buildings;

/**
 * Created by Kingv_000 on 13.10.2015.
 */
public class OfficeBuilding implements Building {
    private DoublyLinkedList<Floor> floors;

    public OfficeBuilding(int i, int[] offices){
        this.floors = new DoublyLinkedList<Floor>();
        for (int j = 0; j < i; j++) {
            floors.add(new OfficeFloor(offices[j]));
        }
    }

    public OfficeBuilding(DoublyLinkedList<Floor> floors){
        this.floors = new DoublyLinkedList<Floor>();
        this.floors = floors;
    }


    public int getFloorsCount(){
        return this.floors.getSize();
    }


    public int getCountOfSpace(){
        int sum = 0;

        for (int i = 0; i < this.floors.getSize(); i++) {
            sum += this.floors.get(i).getCountOfSpace();
        }

        return sum;
    }

    public float getTotalArea(){
        float sum = 0;

        for (int i = 0; i < this.floors.getSize(); i++) {
            sum += this.floors.get(i).getTotalArea();
        }

        return sum;
    }

    public int getTotalRoomsCount(){
        int sum = 0;

        for (int i = 0; i < this.floors.getSize(); i++) {
            sum += this.floors.get(i).getTotalCountOfRooms();
        }

        return sum;
    }

    public Floor[] getFloors(){
        Floor[] floors = new Floor[this.floors.getSize()];

        for (int i = 0; i < this.floors.getSize(); i++) {
            floors[i] = this.floors.get(i);
        }

        return floors;
    }

    public Floor getFloor(int i){
        if (i > this.floors.getSize()) throw new FloorIndexOutOfBoundsException("Index out!");
        else
            return this.floors.get(i);
    }

    public void setFloor(int i, Floor floor){
        this.floors.set(i, floor);
    }

    public Space getSpace(int number){
        int countOFFlat = 0;
        int deepNumberFlat = 0;
        Space office = null;
        for (int i = 0; i < this.floors.getSize(); i++) {
            countOFFlat += this.floors.get(i).getCountOfSpace();

            if (countOFFlat > number){
                if (i != 0) countOFFlat -= this.floors.get(i - 1).getCountOfSpace();
                else countOFFlat -= this.floors.get(i).getCountOfSpace();
                deepNumberFlat = (number - countOFFlat);
                office = this.floors.get(i).getSpace(deepNumberFlat);
                break;
            }
        }

        return office;
    }

    public void setSpace(int number, Space space){
        int countOFFlat = 0;
        int deepNumberFlat = 0;
        for (int i = 0; i < this.floors.getSize(); i++) {
            countOFFlat += this.floors.get(i).getCountOfSpace();

            if (countOFFlat > number){
                if (i != 0) countOFFlat -= this.floors.get(i - 1).getCountOfSpace();
                else countOFFlat -= this.floors.get(i).getCountOfSpace();
                deepNumberFlat = (number - countOFFlat);
                this.floors.get(i).setSpace(number, space);
                break;
            }
        }
    }

    public void addSpace(int number, Space space){
        int countOFFlat = 0;
        int deepNumberFlat = 0;
        for (int i = 0; i < this.floors.getSize(); i++) {
            countOFFlat += this.floors.get(i).getCountOfSpace();

            if (countOFFlat > number){
                if (i != 0) countOFFlat -= this.floors.get(i - 1).getCountOfSpace();
                else countOFFlat -= this.floors.get(i).getCountOfSpace();
                deepNumberFlat = (number - countOFFlat);
                this.floors.get(i).addSpace(space);
                break;
            }
        }
    }

    public void deleteSpace(int number){
        int countOFFlat = 0;
        int deepNumberFlat = 0;
        for (int i = 0; i < this.floors.getSize(); i++) {
            countOFFlat += this.floors.get(i).getCountOfSpace();

            if (countOFFlat > number){
                if (i != 0) countOFFlat -= this.floors.get(i - 1).getCountOfSpace();
                else countOFFlat -= this.floors.get(i).getCountOfSpace();
                deepNumberFlat = (number - countOFFlat);
                this.floors.get(i).deleteSpace(number);
                break;
            }
        }
    }

    public Space getBestSpace(){
        double max = this.floors.get(0).getSpace(0).getArea();
        int index = 0;

        for (int i = 0; i < this.floors.getSize(); i++) {
            for (int j = 0; j < this.floors.get(i).getCountOfSpace(); j++) {
                if (this.floors.get(i).getSpace(j).getArea() > max){
                    max = this.floors.get(i).getSpace(j).getArea();
                    index = j;
                }
            }
        }

        return getSpace(index);
    }

    public Space[] getSortedSpace(){
        Space[] offices = new Space[getCountOfSpace()];
        int k = 0;
        Space buf = null;
        for (int i = 0; i < this.floors.getSize(); i++) {
            for (int j = 0; j < this.floors.get(i).getCountOfSpace(); j++) {
                offices[k] = this.floors.get(i).getSpace(j);
                k++;
            }

        }

        for (int i = 0; i < offices.length; i++) {
            for (int j = 0; j < offices.length; j++) {
                if (offices[i].getArea() > offices[j].getArea()){
                    buf = offices[i];
                    offices[i] = offices[j];
                    offices[j] = buf;
                }
            }
        }

        return offices;
    }

}


