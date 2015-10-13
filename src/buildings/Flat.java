package buildings;

/**
 * Created by Kingv_000 on 05.10.2015.
 */
public class Flat implements Space {
    private static final int DEFAULT_AMOUNT_OF_ROOMS = 2;
    private static final double DEFAULT_AREA = 50;
    private int amountOfRooms;
    private double area;

    public Flat(double area,int amountOfRooms){
        this.area = area;
        this.amountOfRooms = amountOfRooms;
    }

    public Flat() {
        this(DEFAULT_AREA, DEFAULT_AMOUNT_OF_ROOMS);
    }

    public Flat(double area) {
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

    public double getArea() {
        return area;
    }

    public void setArea(double newArea) {
        if (newArea > 0){
            area = newArea;
        } else {
            System.out.println("area <= 0!");
        }
    }
}



