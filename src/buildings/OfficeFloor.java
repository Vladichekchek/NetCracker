package buildings;
import buildings.Floor;
import buildings.Space;
/**
 * Created by Kingv_000 on 13.10.2015.
 */
public class OfficeFloor implements Floor {
    DoublyLinkedList<Space> offices = new DoublyLinkedList<Space>();


    public OfficeFloor(int countOfOffice){
        for (int i = 0; i < countOfOffice; i++) {
            offices.add(new Office());
        }
    }
    public OfficeFloor(Space[] offices){
        for (int i = 0; i < offices.length; i++) {
            this.offices.add(offices[i]);
        }
    }
    public int getTotalCountOfRooms(){
        int sum = 0;

        for (int i = 0; i < this.offices.getSize(); i++) {
            sum += this.offices.get(i).getAmtOfRoom();
        }

        return sum;
    }
    public float getTotalArea(){
        float area = 0;

        for (int i = 0; i < this.offices.getSize(); i++) {
            area += this.offices.get(i).getArea();
        }

        return area;
    }
    public int getCountOfSpace(){
        return this.offices.getSize();
    }
    public Space[] getSpaces(){
        Space[] offices = new Space[this.offices.getSize()];

        for (int i = 0; i < offices.length; i++) {
            offices[i] = this.offices.get(i);
        }

        return offices;
    }
    public Space getSpace(int i){
        if (i > this.offices.getSize()) throw new SpaceIndexOutOfBoundsException("Index out!");
        else
            return this.offices.get(i);
    }
    public void setSpace(int i, Space space){
        this.offices.set(i,(Office)space);
    }
    public void addSpace(Space space){
        this.offices.add((Office)space);
    }
    public void deleteSpace(int i){
        this.offices.delete(i);
    }
    public Space getBestSpace(){
        double max = this.offices.get(0).getArea();
        int index = 0;
        for (int i = 0; i < this.offices.getSize(); i++) {
            if (this.offices.get(i).getArea() > max){
                max = this.offices.get(i).getArea();
                index = i;
            }
        }
        return this.offices.get(index);
    }



}
