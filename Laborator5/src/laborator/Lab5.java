package laborator;

import java.util.Scanner;

import static laborator.Catalog.catalogItems;
public class Lab5 {

    public static void main(String[] args)
    {
        Lab5 app = new Lab5();
        Item song1= new Song("Rezidue","D:\\Melodii\\Rezidue.mp3",2000,5,"song");
        //CatalogUtil.add(song1);
        //CatalogIO.save();
        //CatalogIO.load();
        //CatalogUtil.list();
        //CatalogUtil.play(song1);
        int intValue;
        float floatValue;
        Double doubleValue;
        String stringValue;
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dati un intreg:"); intValue = scanner.nextInt();
        System.out.print("Dati un float:"); floatValue = scanner.nextFloat();
        System.out.print("Dati un double:"); doubleValue = scanner.nextDouble();
        System.out.print("Dati un string:"); stringValue = scanner.next();
        */

        try {
            CatalogCommand command1 = new AddCommand();
            CatalogCommand command2 = new ListCommand();
            CatalogCommand command3 = new PlayCommand();
            //command1.execute(song1);
            command2.execute();
            command3.execute();
        }
        catch (Exception e)
        {
            System.err.println("Oops, " + e);
        }
    }
}
