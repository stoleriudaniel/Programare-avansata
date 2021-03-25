package laborator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    protected String type;
    protected String name;
    protected String location;
    protected int year;
    protected float rating;
    protected Map<String, Object> tags = new HashMap<>();
    public Item(){ }
    public Item(String name){
        this.name=name;
    }
    public Item(String name, String location, int year, float rating, String type){
        this.name=name;
        this.location=location;
        this.year=year;
        this.rating=rating;
        this.type=type;
    }
    public void addTag(String key, Object obj)
    {
        tags.put(key,obj);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setRating(float rating) throws InvalidCatalogException{
        if(rating < 1)
        {
            throw new InvalidCatalogException("Invalid rating");
        }
        else
        {
            this.rating = rating;
        }
    }

    public float getRating() {
        return rating;
    }

    public void setYear(int y) throws InvalidCatalogException {
        if (y < 0) {
            throw new InvalidCatalogException("Invalid year");
        } else {
            this.year = y;
        }
    }

    public int getYear() {
        return year;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public Map<String, Object> getTags() {
        return tags;
    }
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", year='" + year + '\'' +
                ", rating='" + rating + '\'' +
                ",  type='" + type + '\'' +
                '}';
    }
}

