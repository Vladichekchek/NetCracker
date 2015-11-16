package buildings.iterators;

import buildings.Interfaces.Space;
import buildings.collection.DoublyLinkedList;
import buildings.office.Office;

import java.util.Iterator;

/**
 * Created by Kingv_000 on 16.11.2015.
 */
public class OfficeIterator implements Iterator<Office> {
    private DoublyLinkedList<Space> offices;
    private int currNumber;

    public OfficeIterator(DoublyLinkedList<Space> offices){
        this.offices = offices;
        currNumber = 0;
    }

    public boolean hasNext(){
        if (this.currNumber > offices.getSize()) return true;
        return false;
    }

    public Office next(){
        Office office = (Office)this.offices.get(currNumber);
        currNumber++;
        return office;
    }
}
