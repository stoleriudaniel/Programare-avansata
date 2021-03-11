package Laborator3;

import java.util.ArrayList;
import java.util.List;

public class City {
    private List<Location> nodes = new ArrayList<>();
    public City(){}
    public City(List<Location> nodes){
        this.nodes=nodes;
    }

    public List<Location> getNodes() {
        if(nodes==null)
        {
            throw new IllegalArgumentException("Null");
        }
        return nodes;
    }

    public void addLocation(Location node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "City{" +
                "nodes=" + nodes +
                '}';
    }

}
