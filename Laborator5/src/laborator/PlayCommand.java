package laborator;

import java.awt.*;
import java.io.File;

public class PlayCommand extends CatalogCommand{
    @Override
    void execute(Item... items) throws InvalidCatalogException {
        try {
            File file = new File(items[0].getLocation());
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (Exception evt) {
            System.out.println("Oops");
        }
    }
}
