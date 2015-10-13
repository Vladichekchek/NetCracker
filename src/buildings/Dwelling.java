package buildings;

import com.sun.scenario.effect.Flood;

/**
 * Created by Kingv_000 on 05.10.2015.
 */


public class Dwelling  {
    private  DwellingFloor[] floors;
    private int sizeOfDwelling;

    public Dwelling(int amountOfFloor, int[] amountOfFlats){
        this.sizeOfDwelling = amountOfFloor;
        this.floors = new DwellingFloor[amountOfFloor];


    }
    public Dwelling(DwellingFloor[] arrayOfDwellingFloor){
        floors = arrayOfDwellingFloor;
        for (int i = 0; i <floors.length ; i++) {
            floors[i] = new DwellingFloor(10);
        }
        sizeOfDwelling = floors.length;

    }

    public int getNumberOfFloor() {
        return sizeOfDwelling;
    }
    public int getNumberSpaceOfBuilding() {
        int commonAmountOfFlats = 0;
        for(int i = 0; i < sizeOfDwelling; i++) {
            commonAmountOfFlats += floors[i].getNumberOfSpaces();
        }
        return commonAmountOfFlats;
    }
    public double getAllAreaOfBuilding() {
        double commonAreaOfDwelling = 0;
        for(int i = 0; i < sizeOfDwelling; i++) {
            commonAreaOfDwelling += floors[i].getAllAreaOfFloor();
        }
        return commonAreaOfDwelling;
    }

    public int getNumberRoomsOfBuilding() {
        int totalAmountFlatsOfDwelling = 0;
        for (int i = 0; i < sizeOfDwelling; i++) {
            totalAmountFlatsOfDwelling += floors[i].getNumberOfSpaces();
        }
        return totalAmountFlatsOfDwelling;
    }

    public DwellingFloor[] getMassFloor(){
        return floors;
    }
    public DwellingFloor getOneFloor(int numberOfDwelling, DwellingFloor newDwellingFloor){
        return floors[numberOfDwelling]= newDwellingFloor;
    }
    public void changeFloor(int numberOfDwellingFloor,DwellingFloor newDwellingFloor){
        floors[numberOfDwellingFloor]= newDwellingFloor;

    }
    public void changeSpace(int numberOfFlat, Space newFlat) {
        int count = 0;
        for(int i = 0; i < floors.length; i++) {
            if((count <= numberOfFlat)&&(numberOfFlat <= (count + floors[i].getNumberOfSpaces()))){
                floors[i].changeSpace(numberOfFlat - count, newFlat);
            } else {
                count += floors[i].getNumberOfSpaces();
            }
        }
    }


   /* public Space getOneSpace(int numberOfFlat) {
        int count = 0;
        for(int i = 0; i < floors.length; i++) {
            if((count <= numberOfFlat)&&(numberOfFlat <= (count + floors[i].getNumberOfSpaces()))){
                return floors[i].getOneSpace(numberOfFlat - count);
            } else {
                count += floors[i].getNumberOfSpaces();
            }
        }
        return null;
    }*/
   public void addSpace(int numberOfFlat, Space newFlat) {
       int count = 0;
       for(int i = 0; i < floors.length; i++) {
           if((count <= numberOfFlat)&&(numberOfFlat <= (count + floors[i].getNumberOfSpaces()))){
               floors[i].addFitSpace(numberOfFlat - count, newFlat);
           } else {
               count += floors[i].getNumberOfSpaces();
           }
       }
   }
    public Space getBestSpace() {
        Space bestSpace = floors[0].getBestSpace();
        for (int i = 0; i < floors.length; i++) {
            if (bestSpace.getArea() < floors[i].getBestSpace().getArea()) ;
            {
                bestSpace = floors[i].getBestSpace();
            }

        }
        return bestSpace;
    }
    public Space[] sortSpace() {
        Space[] sortedArray = new Flat[this.getNumberRoomsOfBuilding()];
        Space lastMaxFlat = new Flat(this.getBestSpace().getArea());
        double max = 0;
        for(int k = 0; k < sortedArray.length; k++) {
            max = 0;
            for(int i = 0; i < floors.length; i++){
                for(int j = 0; j < floors[i].getNumberOfSpaces();j++) {
                    if((floors[i].getOneSpace(j).getArea() >= max)&&(floors[i].getOneSpace(j).getArea() <= lastMaxFlat.getArea())&&(lastMaxFlat != floors[i].getOneSpace(j))) {
                        max = floors[i].getOneSpace(j).getArea();
                        sortedArray[k] = floors[i].getOneSpace(j);
                    }
                }
            }
            lastMaxFlat = sortedArray[k];
        }
        return sortedArray;
    }





    public void deleteSpace(int number){

    }
    }








