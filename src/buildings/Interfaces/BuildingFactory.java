package buildings.Interfaces;

/**
 * Created by Kingv_000 on 16.11.2015.
 */
public interface BuildingFactory extends Cloneable {

    public Space creatSpace(float area);
    public Space creatSpace(int roomsCount, float area);
    public Floor creatFloor(int specesCount);
    public Floor creatfloor(Space[] spaces);
    public Building creatBuilding(int floorsCount, int[] spacesCounts);
    public Building creatBuilding(Floor[] floors);



}
