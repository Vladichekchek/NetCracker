package buildings;

/**
 * Created by Kingv_000 on 12.10.2015.
 */
public class Office implements Space {
    private int amountOfRooms;
    private float area;
    private static final int DEFAULT_AMOUNT_OF_ROOM = 1;
    public static final float DEFAULT_AREA = 250;


    public Office(float area,int amountOfRoom){
        this.amountOfRooms= amountOfRoom;
        this.area = area;
    }

    public Office(){
        this(DEFAULT_AREA,DEFAULT_AMOUNT_OF_ROOM);
    }

    public Office(float area) {
        this.area = area;
        amountOfRooms = DEFAULT_AMOUNT_OF_ROOM;
    }

    ////////////////////////////////////////////////////////

    public int getAmtOfRoom(){
        return amountOfRooms;
    }

    public void setAmtOfRoom(int newNumbersOfRooms) {
        if(newNumbersOfRooms > 0) {
            amountOfRooms = newNumbersOfRooms;
        } else {
            System.out.println("number of rooms <= 0");
        }
    }
    public float getArea(){
        return area;
    }

    public void setArea(float newArea){
        if (newArea > 0){
            area = newArea;
        }else  System.out.println("area <= 0!");

    }








}
