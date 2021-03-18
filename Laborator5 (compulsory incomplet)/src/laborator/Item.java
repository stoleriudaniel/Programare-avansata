package laborator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    protected String id;
    protected String name;
    protected String location;
    protected Map<String, Object> tags = new HashMap<>();
    public Item(){ }
    public Item(String name){
        this.name=name;
    }
    public Item(String name, String location){
        this.name=name;
        this.location=location;
    }
    public Item(String name, String location, String id){
        this.name=name;
        this.location=location;
        this.id=id;
    }
    public void addTag(String key, Object obj)
    {
        tags.put(key,obj);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public Map<String, Object> getTags() {
        return tags;
    }
}

