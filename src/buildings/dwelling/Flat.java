package buildings.dwelling;

import buildings.Interfaces.Space;

/**
 * Created by Kingv_000 on 05.10.2015.
 */
public class Flat implements Space {
    private static final int DEFAULT_AMOUNT_OF_ROOMS = 2;
    private static final float DEFAULT_AREA = 50;
    private int amountOfRooms;
    private float area;

    public Flat(float area,int amountOfRooms){
        this.area = area;
        this.amountOfRooms = amountOfRooms;
    }

    public Flat() {
        this(DEFAULT_AREA, DEFAULT_AMOUNT_OF_ROOMS);
    }

    public Flat(float area) {
        this.area = area;
        amountOfRooms = DEFAULT_AMOUNT_OF_ROOMS;
    }

    public int getAmtOfRoom() {
        return amountOfRooms;
    }

    public void setAmtOfRoom(int newNumbersOfRooms) {
        if(newNumbersOfRooms > 0) {
            amountOfRooms = newNumbersOfRooms;
        } else {
            System.out.println("number of rooms <= 0");
        }
    }

    public float getArea() {
        return area;
    }

    public void setArea(float newArea) {
        if (newArea > 0){
            area = newArea;
        } else {
            System.out.println("area <= 0!");
        }
    }
}



