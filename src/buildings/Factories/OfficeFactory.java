package buildings.Factories;

import buildings.Interfaces.Building;
import buildings.Interfaces.BuildingFactory;
import buildings.Interfaces.Floor;
import buildings.Interfaces.Space;
import buildings.dwelling.Flat;
import buildings.office.Office;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFloor;

/**
 * Created by Kingv_000 on 16.11.2015.
 */
public class OfficeFactory implements BuildingFactory {
    public Space creatSpace(float area){
        return new Office(area);

    }
    public Space creatSpace(int roomsCount, float area){
        return new Office(area, roomsCount);

    }
    public Floor creatFloor(int specesCount){
        return new OfficeFloor(specesCount);

    }
    public Floor creatfloor(Space[] spaces){
        return new OfficeFloor(spaces);

    }
    public Building creatBuilding(int floorsCount, int[] spacesCounts){
        return new OfficeBuilding(floorsCount, spacesCounts);

    }
    public Building creatBuilding(Floor[] floors){
        return new OfficeBuilding(floors);


    }

}
