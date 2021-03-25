package laborator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadCommand extends CatalogCommand{
    @Override
    void execute(Item... items) throws InvalidCatalogException {
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
