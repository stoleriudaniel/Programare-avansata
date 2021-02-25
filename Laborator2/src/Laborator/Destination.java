package Laborator;

import java.util.Objects;

public class Destination{
    private String name;
    public Destination(){

    }
    public Destination(String name)
    {
        this.name=name;
    }

    public void setName(String name) {
        if(name==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        this.name = name;
    }

    public String getName()
    {
        if(name==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return name;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Destination)) {
            return false;
        }
        Destination other = (Destination) obj;
        return name.equals(other.name);
    }

}