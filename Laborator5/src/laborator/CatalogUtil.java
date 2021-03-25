package laborator;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static laborator.Catalog.catalogItems;

public class CatalogUtil{
    public static void add(Item item) {
        catalogItems.add((item));
    }
    public static void list() {
        for (Item item : catalogItems) {
            System.out.println(item);
        }
    }

    public static void play(Item song) {
        try {
            File file = new File(song.getLocation());
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (Exception evt) {
            System.out.println("Oops");
        }
    }
}
