import buildings.DwellingFloor;
import buildings.Flat;

/**
 * Created by Kingv_000 on 06.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        DwellingFloor floor = new DwellingFloor(3);
        Flat flat2 = new Flat();
        Flat flat1 = new Flat(300);
        floor.addFitSpace(1, flat1);
        flat2 = floor.getBestSpace();
        System.out.println((flat2 = floor.getOneSpace(1)).getArea());
        System.out.println(flat2.getArea());
        System.out.println("ollolol");
    }
}
