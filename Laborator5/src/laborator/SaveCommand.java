package laborator;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand extends CatalogCommand{
    @Override
    void execute(Item... items) throws InvalidCatalogException {
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
}
