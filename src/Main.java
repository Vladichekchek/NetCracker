import buildings.*;
import buildings.Interfaces.Building;
import buildings.Interfaces.Floor;
import buildings.dwelling.Dwelling;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFloor;
import buildings.collection.DoublyLinkedList;

import java.io.*;

/**
 * Created by Kingv_000 on 06.10.2015.
 */
public class Main {
    public static void main(String[] args) {

        OfficeFloor officeFloor = new OfficeFloor(5);
        OfficeFloor officeFloor1 = new OfficeFloor(5);
        DoublyLinkedList<Floor> floors = new DoublyLinkedList<Floor>();
        floors.add(officeFloor);
        floors.add(officeFloor1);

        OfficeBuilding officeBuilding = new OfficeBuilding(floors);


        Building building = null;
        try {
            building = Buildings.inputBuilding(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }


        PrintWriter buffredWrite1 = new PrintWriter(new OutputStreamWriter(System.out));

            Buildings.writeBuilding(officeBuilding,buffredWrite1);



    }





}

