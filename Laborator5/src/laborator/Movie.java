package laborator;

public class Movie extends Item{
    public Movie(){}
    public Movie(String name)
    {
        super(name);
    }
    public Movie(String name, String location, int year, float rating, String type)
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


    @Override
    public String toString() {
        return super.toString();
    }
}
