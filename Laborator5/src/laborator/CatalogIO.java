package laborator;

import java.io.*;

import static laborator.Catalog.catalogItems;

public class CatalogIO {
    //save and load methods
    public static void save() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("D:\\Items\\myItems.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, 1024);
            for (Item item : catalogItems) {
                bufferedWriter.write(item.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            System.err.println("Fisierul myItems.txt lipseste!");
        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisier!");
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.err.println("Eroare la inchiderea fisierului!");
                }
            }
        }
    }
    public static void load() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("D:\\Items\\myItems.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            String line = bufferedReader.readLine();
            while (line != null) {
                //ConvertLine(line);
                String[] arrOfStr = line.split("'", 12);
                if(arrOfStr[9].equals("song")) {
                    Item item = new Song(arrOfStr[1], arrOfStr[3], Integer.parseInt(arrOfStr[5]), Float.parseFloat(arrOfStr[7]), arrOfStr[9]);
                    CatalogUtil.add(item);
                }
                if(arrOfStr[9].equals("movie")) {
                    Item item = new Movie(arrOfStr[1], arrOfStr[3], Integer.parseInt(arrOfStr[5]), Float.parseFloat(arrOfStr[7]), arrOfStr[9]);
                    CatalogUtil.add(item);
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fisierul myItems.txt lipseste!");
        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisier!!");
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.err.println("Eroare la inchiderea fisierului!");
                }
            }
        }
    }
}
