package buildings.dwelling;

import buildings.Interfaces.Floor;
import buildings.Interfaces.Space;

/**
 * Created by Kingv_000 on 05.10.2015.
 */
public class DwellingFloor implements Floor {
    private Space[] flats;
    private int sizeOfDwellingFloor;

    public int getCountOfSpace(){
        return flats.length;

    }


    public DwellingFloor(int amountOfFlats) {
        flats = new Space[amountOfFlats];
        for(int i = 0; i < flats.length; i++) {
            flats[i] = new Flat();
        }

        sizeOfDwellingFloor = amountOfFlats;
    }

    public DwellingFloor(Space[] spaces) {
        this.flats = spaces;
    }

    public int getNumberOfSpaces() {
        return flats.length;
    }

    public float getTotalArea() {
        float totalAreaFloor = 0;
        for(int i = 0; i < sizeOfDwellingFloor; i++) {
            totalAreaFloor += flats[i].getArea();
        }
        return totalAreaFloor;
    }

    public int getTotalCountOfRooms() {
        int totalAmountOfRooms = 0;
        for(int i = 0; i < sizeOfDwellingFloor; i++) {
            totalAmountOfRooms += flats[i].getAmtOfRoom();
        }
        return totalAmountOfRooms;
    }

    public Space[] getSpaces() {
        return flats;
    }

    public Space getSpace(int numberOfFlat) {
        return flats[numberOfFlat];
    }

    public Space getBestSpace() {
        double maxArea = 0;
        int numberOfFlat = 0;
        for(int i = 0; i < flats.length; i++) {
            if(maxArea < flats[i].getArea()) {
                maxArea = flats[i].getArea();
                numberOfFlat = i;
            }
        }
        return flats[numberOfFlat];
    }

    public void changeSpace(int numberOfFlat, Space newFlat) {
        flats[numberOfFlat].setArea(newFlat.getArea());
        flats[numberOfFlat].setAmtOfRoom(newFlat.getAmtOfRoom());
    }


    public void addFitSpace(int numberOfFlat, Space newFlat) {
        Space[] tempFlats = new Space[flats.length + 1];
        int j = 0;
        for(int i = 0; i < flats.length + 1; i++) {
            if(i == numberOfFlat) {
                tempFlats[i] = newFlat;

            } else {
                tempFlats[i] = flats[j];
                j++;
            }
        }
        flats = tempFlats;
    }

    public void deleteSpace(int numberOfFlat) {
        Space[] tempFlats = new Flat[flats.length - 1];
        int j = 0;
        for (int i = 0; i < flats.length; i++) {
            if (i != numberOfFlat) {
                tempFlats[j] = flats[i];
                j++;
            }
        }
        flats = tempFlats;
    }
    public void addSpace(Space space){
        Space[] buffFlats = new Flat[this.flats.length + 1];
        for (int i = 0; i <this.flats.length ; i++) {
            buffFlats[i] = this.flats[i];
        }
        buffFlats[buffFlats.length - 1 ] = space;
        this.flats = buffFlats;
    }
    public void setSpace(int number,Space space){
        this.flats[number] = space;

    }
}