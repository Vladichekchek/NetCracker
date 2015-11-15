package buildings.dwelling.hotel;

import buildings.Interfaces.Building;
import buildings.Interfaces.Floor;
import buildings.Interfaces.Space;
import buildings.dwelling.DwellingFloor;

import java.util.Iterator;

/**
 * Created by Kingv_000 on 03.11.2015.
 */
public class HotelFloor extends DwellingFloor {
    private int countOfStars;
    private final int DEFAULT_COUNT_OF_STARS=1;

    public HotelFloor (Space[] spaces){
        super(spaces);
        this.countStars = DEFAULT_COUNT_OF_STARS;
    }
    public HotelFloor(int countOfSpace){
        super(countOfSpace);
        this.countStars = DEFAULT_COUNT_OF_STARS;
    }





    private int countStars;
    public int getCountStars() {
        return countStars;
    }

    public void setCountStars(int countStars) {
        this.countStars = countStars;
    }



}
