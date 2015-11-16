package buildings.Factories;

import buildings.Interfaces.Building;
import buildings.Interfaces.BuildingFactory;
import buildings.Interfaces.Floor;
import buildings.Interfaces.Space;
import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;

/**
 * Created by Kingv_000 on 16.11.2015.
 */
public class DwellingFactory implements BuildingFactory{
    public Space creatSpace(float area){
        return new Flat(area);
    }
    public Space creatSpace(int roomsCount, float area) {
        return new Flat(area,roomsCount);
    }
    public Floor creatFloor(int specesCount){
        return new DwellingFloor(specesCount);
    }
    public Floor creatfloor(Space[] spaces){
        return new DwellingFloor(spaces);
    }
    public Building creatBuilding(int floorsCount, int[] spacesCounts){
        return new Dwelling(floorsCount,spacesCounts);
    }
    public Building creatBuilding(Floor[] floors){
        return new Dwelling(floors);
    }


}
