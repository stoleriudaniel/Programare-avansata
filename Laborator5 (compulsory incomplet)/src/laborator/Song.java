package laborator;

public class Song extends Item{
    public Song(){}
    public Song(String name){
        super(name);
    }
    public Song(String name, String location)
    {
        super(name,location);
    }
    public Song(String name, String location, String id)
    {
        super(name,location,id);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
