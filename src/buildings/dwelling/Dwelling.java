package buildings.dwelling;

import buildings.Interfaces.Building;
import buildings.Interfaces.Floor;
import buildings.Interfaces.Space;
import buildings.exceptions.FloorIndexOutOfBoundsException;

/**
 * Created by Kingv_000 on 05.10.2015.
 */


public class Dwelling implements Building {
    private Floor[] dwellingFloors;

    public Dwelling(int countOfFloor, int[] countOfFlat){
        this.dwellingFloors = new DwellingFloor[countOfFloor];

        for (int i = 0; i < countOfFlat.length; i++) {
            this.dwellingFloors[i] = new DwellingFloor(countOfFlat[i]);
        }
    }

    public Dwelling(Floor[] dwellingFloors){
        this.dwellingFloors = dwellingFloors;
    }

    public int getFloorsCount(){
        return this.dwellingFloors.length;
    }

    public int getCountOfSpace(){
        int countOfFlat = 0;

        for (int i = 0; i < this.dwellingFloors.length; i++) {
            countOfFlat += this.dwellingFloors[i].getCountOfSpace();
        }

        return countOfFlat;
    }

    public float getTotalArea(){
        int totalArea = 0;

        for (int i = 0; i < this.dwellingFloors.length; i++) {
            totalArea += this.dwellingFloors[i].getTotalArea();
        }

        return totalArea;
    }

    public int getTotalRoomsCount(){
        int totalRoomsCount = 0;

        for (int i = 0; i < this.dwellingFloors.length; i++) {
            totalRoomsCount += this.dwellingFloors[i].getTotalCountOfRooms();
        }

        return totalRoomsCount;
    }

    public Floor[] getFloors(){
        return this.dwellingFloors;
    }

    public Floor getFloor(int number){
        if (number > this.dwellingFloors.length) throw new FloorIndexOutOfBoundsException("Index out!");
        else
            return this.dwellingFloors[number];
    }

    public void setFloor(int number, Floor floor){
        this.dwellingFloors[number] = floor;
    }

    public Flat getSpace(int numberFlat){
        int countOFFlat = 0;
        Flat flat = null;
        int deepNumberFlat = 0;
        for (int i = 0; i < this.dwellingFloors.length; i++) {
            countOFFlat += this.dwellingFloors[i].getCountOfSpace();

            if (countOFFlat > numberFlat){
                if (i != 0) countOFFlat -= this.dwellingFloors[i - 1].getCountOfSpace();
                else countOFFlat -= this.dwellingFloors[i].getCountOfSpace();
                deepNumberFlat = (numberFlat - countOFFlat);
                flat = (Flat)this.dwellingFloors[i].getSpace(deepNumberFlat);
                break;
            }
        }

        return flat;
    }

    public void setSpace(int numberFlat, Space space){
        int countOFFlat = 0;
        int deepNumberFlat = 0;
        for (int i = 0; i < this.dwellingFloors.length; i++) {
            countOFFlat += this.dwellingFloors[i].getCountOfSpace();

            if (countOFFlat >= numberFlat){
                if (i != 0) countOFFlat -= this.dwellingFloors[i - 1].getCountOfSpace();
                else countOFFlat -= this.dwellingFloors[i].getCountOfSpace();
                deepNumberFlat = (numberFlat - countOFFlat);
                this.dwellingFloors[i].setSpace(deepNumberFlat, space);
                break;
            }
        }

    }

    public void addSpace(int numberFlat, Space space){
        int countOFFlat = 0;
        int deepNumberFlat = 0;
        for (int i = 0; i < this.dwellingFloors.length; i++) {
            countOFFlat += this.dwellingFloors[i].getCountOfSpace();

            if (countOFFlat >= numberFlat){
                if (i != 0) countOFFlat -= this.dwellingFloors[i - 1].getCountOfSpace();
                else countOFFlat -= this.dwellingFloors[i].getCountOfSpace();
                deepNumberFlat = (numberFlat - countOFFlat);
                this.dwellingFloors[i].addSpace(space);
                break;
            }
        }

    }

    public void deleteSpace(int numberFlat){
        int countOFFlat = 0;
        int deepNumberFlat = 0;
        for (int i = 0; i < this.dwellingFloors.length; i++) {
            countOFFlat += this.dwellingFloors[i].getCountOfSpace();

            if (countOFFlat >= numberFlat){
                if (i != 0) countOFFlat -= this.dwellingFloors[i - 1].getCountOfSpace();
                else countOFFlat -= this.dwellingFloors[i].getCountOfSpace();
                deepNumberFlat = (numberFlat - countOFFlat);
                this.dwellingFloors[i].deleteSpace(deepNumberFlat);
                break;
            }
        }


    }

    public Space getBestSpace(){
        Space bestFlat = this.dwellingFloors[0].getBestSpace();

        for (int i = 0; i < this.dwellingFloors.length; i++) {
            if (this.dwellingFloors[i].getBestSpace().getArea() > bestFlat.getArea()){
                bestFlat = this.dwellingFloors[i].getBestSpace();
            }
        }

        return bestFlat;
    }

    public Space[] getSortedSpace(){
        Space[] sortedFlats = new Flat[getCountOfSpace()];
        int a = 0;
        for (int i = 0; i < this.dwellingFloors.length; i++) {
            for (int j = 0; j <this.dwellingFloors[i].getCountOfSpace() ; j++) {
                sortedFlats[a] = this.dwellingFloors[i].getSpace(j);
                a++;
            }
        }

        Space bufFlat = null;

        for (int i = 0; i < sortedFlats.length; i++) {
            for (int j = 0; j < sortedFlats.length; j++) {
                if (sortedFlats[i].getArea() > sortedFlats[j].getArea()){
                    bufFlat = sortedFlats[i];
                    sortedFlats[i] = sortedFlats[j];
                    sortedFlats[j] = bufFlat;
                }
            }
        }


        return sortedFlats;
    }





}