package buildings.Interfaces;

import java.io.Serializable;

/**
 * Created by Kingv_000 on 26.10.2015.
 */
public interface Floor extends Serializable{
    public int getCountOfSpace();

    public float getTotalArea();

    public int getTotalCountOfRooms();

    public Space[] getSpaces();

    public Space getSpace(int number);

    public void setSpace(int number, Space space);

    public void addSpace(Space space);

    public void deleteSpace(int number);

    public Space getBestSpace();
}

