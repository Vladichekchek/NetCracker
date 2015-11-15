package buildings.iterators;

import buildings.dwelling.Flat;

import java.util.Iterator;

/**
 * Created by Kingv_000 on 15.11.2015.
 */
public class FlatIterator implements Iterator<Flat> {
    private Flat[] flats;
    private int currentNumber;

    public FlatIterator(Flat[] flats){
        this.flats = flats;
        this.currentNumber = 0;
    }

    public boolean hasNext(){
        if (this.currentNumber < flats.length) return true;

        return false;
    }

    public Flat next(){
        Flat flat = this.flats[currentNumber];
        currentNumber++;
        return flat;
    }
}