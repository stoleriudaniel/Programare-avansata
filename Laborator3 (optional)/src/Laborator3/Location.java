package Laborator3;

import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Comparable<Location> {
    protected String name;
    protected Map<Location, Integer> cost = new HashMap<>();
    public Location(){}
    public Location(String name, Map<Location, Integer> cost){
        this.name=name;
        this.cost=cost;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        if(name==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return name;
    }

    public Map<Location, Integer> getCost() {
        if(cost==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return cost;
    }
    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Location other) {
        if(name==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return this.name.compareTo(other.name);
    }
}
