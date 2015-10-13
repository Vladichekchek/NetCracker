package buildings;

import buildings.Flat;

/**
 * Created by Kingv_000 on 05.10.2015.
 */
public class DwellingFloor  {
    private Flat[] flats;
    private int sizeOfDwellingFloor;


    public DwellingFloor(int amountOfFlats) {
        flats = new Flat[amountOfFlats];
        for(int i = 0; i < flats.length; i++) {
            flats[i] = new Flat();
        }

        sizeOfDwellingFloor = amountOfFlats;
    }

    public DwellingFloor(Flat[] flats) {
        this.flats = flats;
        sizeOfDwellingFloor = flats.length;
    }

    public int getNumberOfSpaces() {
        return flats.length;
    }

    public double getAllAreaOfFloor() {
        double totalAreaFloor = 0;
        for(int i = 0; i < sizeOfDwellingFloor; i++) {
            totalAreaFloor += flats[i].getArea();
        }
        return totalAreaFloor;
    }

    public int getNumberRoomsOfSpaces() {
        int totalAmountOfRooms = 0;
        for(int i = 0; i < sizeOfDwellingFloor; i++) {
            totalAmountOfRooms += flats[i].getAmtOfRoom();
        }
        return totalAmountOfRooms;
    }

    public Flat[] getMassSpaces() {
        return flats;
    }

    public Flat getOneSpace(int numberOfFlat) {
        return flats[numberOfFlat];
    }

    public Flat getBestSpace() {
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

    public void changeSpace(int numberOfFlat, Flat newFlat) {
        flats[numberOfFlat].setArea(newFlat.getArea());
        flats[numberOfFlat].setAmtOfRoom(newFlat.getAmtOfRoom());
    }


    public void addFitSpace(int numberOfFlat, Flat newFlat) {
        Flat[] tempFlats = new Flat[flats.length + 1];
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
        Flat[] tempFlats = new Flat[flats.length - 1];
        int j = 0;
        for (int i = 0; i < flats.length; i++) {
            if (i != numberOfFlat) {
                tempFlats[j] = flats[i];
                j++;
            }
        }
        flats = tempFlats;
    }
    public void changeSpace(int number, Space newSpace){

    }
    public void addNewSpace(int number){

    }
    public void addFitSpace(int number, Space newSpace){

    }


}