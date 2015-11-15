package buildings.iterators;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;

import java.util.Iterator;

/**
 * Created by Kingv_000 on 15.11.2015.
 */
public class DwellingFloorIterator implements Iterator<DwellingFloor>{

    private DwellingFloor[] dwellingFloors;
    private int currNumber;
    public DwellingFloorIterator(DwellingFloor[] dwellingFloors){
        this.dwellingFloors = dwellingFloors;
        currNumber = 0;
    }

    public boolean hasNext(){
        if (currNumber <dwellingFloors.length) return true;
        return false;
    }

    public DwellingFloor next(){
        DwellingFloor dwellingFloor = this.dwellingFloors[currNumber];
        currNumber++;
        return dwellingFloor;
    }


}
