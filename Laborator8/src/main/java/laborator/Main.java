package laborator;

import laborator.dao.Genres;
import laborator.dao.Movies;

public class Main {
    public static void main(String[] args)
    {
        Singleton singleton = Singleton.getInstance();
        singleton.setUrl("jdbc:mysql://localhost:3307/db");
        singleton.setUser("root");
        singleton.setPassword("STUDENT");
        singleton.getConnection();
        Movies.init();
        Movies.findByID(2,singleton.getConnection());
        System.out.println();
        Genres.init();
        Genres.findByID(1,singleton.getConnection());
        //Genres.insertNewRow("SF",singleton.getConnection());
        Movies.insertNewRow("Armageddon","1998-06-30",90,4,singleton.getConnection());
        Tools.insertRowsFromIMDbFile();
    }
}
