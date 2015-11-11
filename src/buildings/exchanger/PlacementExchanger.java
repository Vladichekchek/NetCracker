package buildings.exchanger;

import buildings.exceptions.InexchangeableFloorsException;
import buildings.exceptions.InexchangeableSpacesException;
import buildings.Interfaces.Building;
import buildings.Interfaces.Floor;
import buildings.Interfaces.Space;
import buildings.exceptions.SpaceIndexOutOfBoundsException;

/**
 * Created by Kingv_000 on 28.10.2015.
 */
public class PlacementExchanger {
    public static boolean canExchangeSpace(Space space, Space space1) {
        if (space.getArea() == space1.getAmtOfRoom() && space.getAmtOfRoom() == space1.getAmtOfRoom())
            return true;
        else return false;
    }

    public static boolean canExchangeFloor(Floor floor, Floor floor1) {
        if (floor.getTotalArea() == floor1.getTotalArea() && floor.getTotalCountOfRooms() == floor1.getTotalCountOfRooms())
            return true;
        else return false;
    }

    public static boolean exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2) {
        //метод должен проверять возможность обмена помещениями и допустимость номеров помещений,выбрасывать при необходимости соответ.искл.
        if (index1 > floor1.getCountOfSpace())
            throw new InexchangeableSpacesException("SpaceIndexOutOfBoundsException");
        if (index2 > floor2.getCountOfSpace()) throw new SpaceIndexOutOfBoundsException("SpaceIndexOutOfBoundsException");

        if (floor1.getSpace(index1).getArea() == floor2.getSpace(index2).getArea() && floor1.getSpace(index1).getAmtOfRoom() == floor2.getSpace(index2).getAmtOfRoom())
            return true;
        else return false;
    }

    public static boolean exchangeBuildingFloors (Building building1, int index1, Building building2, int index2){
      if (index1 > building1.getFloorsCount()) throw new InexchangeableFloorsException("FloorsIndexOutOfBoundsException");
      if (index2 > building2.getFloorsCount()) throw new InexchangeableFloorsException("FloorsIndexOutOfBoundsException");
      return canExchangeFloor(building1.getFloor(index1), building2.getFloor(index2));
    }
}







