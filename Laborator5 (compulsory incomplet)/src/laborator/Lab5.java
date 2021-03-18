package laborator;

public class Lab5 {
    public static void main(String[] args)
    {
        Lab5 app = new Lab5();
        //app.testCreateSave();
        //app.testLoadView();
    }
    private void testCreateSave()
    {
        Catalog catalog = new Catalog("My Movies");
        var movie1 = new Movie("Lord of the rings");
        var song1 = new Song("7orange");
        catalog.add(movie1);
        catalog.add(song1);
        //CatalogIO.save();
    }
    private void testLoadView() {
        //Catalog catalog = CatalogIO.load("d:/java/catalog.ser");
        //CatalogUtil.view(catalog.findById("bestSong"));
    }

}
