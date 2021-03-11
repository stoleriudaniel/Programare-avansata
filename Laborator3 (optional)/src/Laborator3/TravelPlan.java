package Laborator3;

import java.util.ArrayList;
import java.util.List;

public class TravelPlan {
    private List<Location> nodes = new ArrayList<>();
    public TravelPlan(City city){
        this.nodes=city.getNodes();
    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    public List<Location> getNodes() {
        return nodes;
    }
}
