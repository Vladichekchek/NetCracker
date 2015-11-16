package buildings;

import buildings.Factories.DwellingFactory;
import buildings.Factories.OfficeFactory;
import buildings.Interfaces.Building;
import buildings.Interfaces.BuildingFactory;
import buildings.Interfaces.Floor;
import buildings.Interfaces.Space;
import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Kingv_000 on 28.10.2015.
 */
public class Buildings {

    private static BuildingFactory buildingFactory= new DwellingFactory();

    public static void setBuildingFactory(BuildingFactory buildingFactoryS){
     buildingFactory = buildingFactoryS;
    }



    public static void outputBuilding(Building building, OutputStream out) {
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        try {
            dataOutputStream.writeByte(building.getFloorsCount());
            for (int i = 0; i < building.getFloorsCount(); i++) {
                dataOutputStream.writeByte(building.getFloor(i).getCountOfSpace());
                for (int j = 0; j < building.getFloor(i).getCountOfSpace(); j++) {
                    dataOutputStream.writeByte(building.getFloor(i).getSpace(j).getAmtOfRoom());
                    dataOutputStream.writeFloat(building.getFloor(i).getSpace(j).getArea());
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static Dwelling inputBuilding(InputStream in) throws IOException {
        int countOfFloor = 0;
        int countOfFlats = 0;
        DataInputStream dataInputStream = new DataInputStream(in);
        countOfFlats = dataInputStream.readByte();
        Floor[] floors = new Floor[countOfFloor];
        for (int i = 0; i < floors.length; i++) {
            countOfFlats = dataInputStream.readByte();
            floors[i] = new DwellingFloor(countOfFlats);
            for (int j = 0; j < countOfFlats; j++) {
                floors[i].setSpace(j, new Flat(dataInputStream.readFloat(), dataInputStream.readByte()));

            }

        }
        Dwelling dwelling = new Dwelling(floors);
        return dwelling;

    }


    public static void writeBuilding(Building building, Writer writer) {
        String outBuilding = "";
        outBuilding += building.getFloorsCount() + " ";
        for (int i = 0; i < building.getFloorsCount(); i++) {
            outBuilding += building.getFloor(i).getCountOfSpace() + " ";
            for (int j = 0; j < building.getFloor(i).getCountOfSpace(); j++) {
                outBuilding += String.valueOf(building.getFloor(i).getSpace(j).getAmtOfRoom()) + " ";
                outBuilding += String.valueOf(building.getFloor(i).getSpace(j).getArea()) + " ";
            }

        }

        try {
            writer.write(outBuilding);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static Building readBuilding(Reader in) throws IOException {

        int index = 1;
        BufferedReader bufferedReader = new BufferedReader(in);
        Scanner scanner = new Scanner(in);
        int countOfFloor = scanner.nextInt();
        Floor[] floors = new DwellingFloor[countOfFloor];
        int countOfFlats = 0;
        for (int i = 0; i < floors.length; i++) {
            countOfFlats = scanner.nextInt();
            floors[i] = new DwellingFloor(countOfFlats);
            for (int j = 0; j < countOfFlats; j++) {
                floors[i].setSpace(j, new Flat(Float.valueOf(scanner.next()),scanner.nextInt()));
            }
        }
        Dwelling dwelling = new Dwelling(floors);
        return dwelling;

    }






    public static Space createSpace(float area){
        return buildingFactory.creatSpace(area);
    }

    public static Space createSpace(int roomsCount, float area){
        return buildingFactory.creatSpace(roomsCount, area);
    }

    public static Floor createFloor(int spacesCount){
        return buildingFactory.creatFloor(spacesCount);
    }

    public static Floor createFloor(Space[] spaces){
        return buildingFactory.creatfloor(spaces);
    }

    public static Building createBuilding(int floorsCount, int[] spacesCounts){
        return buildingFactory.creatBuilding(floorsCount, spacesCounts);
    }

    public static Building createBuilding(Floor[] floors){
        return buildingFactory.creatBuilding(floors);
    }


}

