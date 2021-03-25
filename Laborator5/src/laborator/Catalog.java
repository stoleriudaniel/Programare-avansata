package laborator;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    protected static String name;
    protected static String path;
    protected static List<Item> catalogItems = new ArrayList<>();
    public Catalog(){}
    public Catalog(String name){
        this.name=name;
    }
    public Catalog(String name, String path){
        this.name=name;
        this.path=path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setItems(List<Item> catalogItems) {
        this.catalogItems = catalogItems;
    }

    public List<Item> getItems() {
        return catalogItems;
    }
}
