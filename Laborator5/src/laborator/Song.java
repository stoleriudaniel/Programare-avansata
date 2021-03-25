package laborator;

public class Song extends Item{
    public Song(){}
    public Song(String name){
        super(name);
    }
    public Song(String name, String location, int year, float rating, String type)
    {
        super(name,location,year,rating,type);
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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

}
