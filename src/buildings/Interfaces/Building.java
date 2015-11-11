package buildings.Interfaces;

import java.io.Serializable;

/**
 * Created by Kingv_000 on 26.10.2015.
 */
public interface Building extends Serializable{
    public int getFloorsCount();

    public int getCountOfSpace();

    public float getTotalArea();

    public int getTotalRoomsCount();

    public Floor[] getFloors();

    public Floor getFloor(int number);

    public void setFloor(int number, Floor floor);

    public Space getSpace(int numberFlat);

    public void setSpace(int numberFlat, Space space);

    public void addSpace(int numberFlat, Space space);

    public void deleteSpace(int numberFlat);

    public Space getBestSpace();

    public Space[] getSortedSpace();


}