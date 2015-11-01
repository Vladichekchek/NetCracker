package buildings;

import java.io.*;

/**
 * Created by Kingv_000 on 28.10.2015.
 */
public class Buildings {
    public static void outputBuilding (Building building, OutputStream out) throws IOException{
        out.write(building.getFloorsCount());
        for (int i = 0; i <building.getFloorsCount() ; i++) {
            out.write(building.getFloor(i).getCountOfSpace());//кол-во квартир
            for (int j = 0; j < building.getFloor(i).getCountOfSpace(); j++) {
                out.write(building.getSpace(j).getAmtOfRoom());
                out.write((byte)building.getSpace(j).getArea());
            }
            out.close();
        }
    }

    public static Dwelling inputBuilding(InputStream in) throws IOException {
        int amtOfFloor = 0;
        int amtOfFlats = 0;
        amtOfFloor = in.read();
        Floor[] floors = new Floor[amtOfFloor];

        for (int i = 0; i < floors.length; i++) {
            amtOfFlats = in.read();
            floors[i] = new DwellingFloor(amtOfFlats);

            for (int j = 0; j < amtOfFlats; j++) {
                floors[i] = new DwellingFloor(amtOfFlats);

                floors[i].setSpace(j, new Flat(in.read(), in.read()));
            }

        }
        return new Dwelling(floors);


    }
    public static void writeBuilding (Building building, Writer writer) throws IOException{
        writer.write(building.getFloorsCount() + "\r\n");
        for (int i = 0; i < building.getFloorsCount(); i++) {
            writer.write(building.getFloor(i).getCountOfSpace() + " ");

            for (int j = 0; j < building.getFloor(i).getCountOfSpace(); j++) {
                writer.write(String.valueOf(building.getFloor(i).getSpace(j).getAmtOfRoom()) + " ");
                writer.write(String.valueOf(building.getFloor(i).getSpace(j).getArea()) + " ");
            }
            writer.write("\r\n");
            
        }
        writer.close();

    }
    public static Building readBuilding(Reader in) throws IOException{
        int index = 0;
        BufferedReader bufferedReader = new BufferedReader(in);
        int countOfFloor = Integer.parseInt(bufferedReader.readLine());
        Floor[] floors = new DwellingFloor[countOfFloor];
        String[] floor;
        for (int i = 0; i < floors.length; i++) {
            floor = bufferedReader.readLine().split(" ");
            for (int j = 0; j < floor.length; j++) {
                if (j == 0) floors[i] = new DwellingFloor(Integer.parseInt(floor[0]));
                if (j != 0) {
                    if (j % 2 != 0) {

                       floors[i].setSpace(index, new Flat( Float.valueOf(j + 1), Integer.parseInt(floor[j])));
                        index++;
                    }
                }

            }
            index = 0;
        }
        Building building = new Dwelling(floors);
     return building;
    }

}
