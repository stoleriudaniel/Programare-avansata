package laborator;

import laborator.dao.Genres;
import laborator.dao.Movies;

public class Main {
    public static void main(String[] args)
    {
        Singleton.setUrl("jdbc:mysql://localhost:3307/db");
        Singleton.setUser("root");
        Singleton.setPassword("STUDENT");
        Singleton.getConnection();
        Movies.init();
        Movies.findByID(2,Singleton.getConnection());
        System.out.println();
        Genres.init();
        Genres.findByID(1,Singleton.getConnection());
        //Genres.insertNewRow("SF",Singleton.getConnection());
        Movies.insertNewRow("Armageddon","1998-06-30",90,4,Singleton.getConnection());
        Tools.insertRowsFromIMDbFile();
    }
}
