package buildings.iterators;

import buildings.office.OfficeFloor;

import java.util.Iterator;

/**
 * Created by Kingv_000 on 16.11.2015.
 */
public class OfficeFloorIterator implements Iterator<OfficeFloor> {
    private OfficeFloor[] floors;
    private int currNumber;

    public OfficeFloorIterator(OfficeFloor[] floor){
        this.floors = floor;
        this.currNumber = 0;
    }
    public boolean hasNext(){
        if(this.currNumber > 0) return true;
        return false;
    }
    public  OfficeFloor next(){
        OfficeFloor officeFloor = this.floors[currNumber];
        currNumber++;
        return officeFloor;
    }

}
