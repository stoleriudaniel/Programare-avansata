package Laborator;

import java.util.Arrays;

public class Problem{
    private Source[] sources;
    private Destination[] destinations;

    private int supply[];
    private int demand[];
    private int cost[][];
    public Problem(){

    }
    public Problem(Source[] sources, Destination[] destinations, int[] supply, int[] demand, int[][] cost){
        this.sources = sources;
        this.destinations = destinations;
        this.supply = supply;
        this.demand = demand;
        this.cost = cost;
    }

    public void setSources(Source[] sources) {
        if(sources==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        this.sources = sources;
    }

    public Source[] getSources() {
        if(sources==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return sources;
    }

    public void setDestinations(Destination[] destinations) {
        if(destinations==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        this.destinations = destinations;
    }

    public Destination[] getDestinations() {
        if(destinations==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return destinations;
    }

    public void setSupply(int[] supply) {
        if(supply==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        this.supply = supply;
    }

    public int[] getSupply() {
        if(supply==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return supply;
    }

    public void setDemand(int[] demand) {
        if(demand==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        this.demand = demand;
    }

    public int[] getDemand()
    {
        if(demand==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return demand;
    }

    public void setCost(int[][] cost) {
        if(cost==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        this.cost = cost;
    }

    public int[][] getCost() {
        if(cost==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return cost;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "sources=" + Arrays.toString(sources) +
                ", destinations=" + Arrays.toString(destinations) +
                ", supply=" + Arrays.toString(supply) +
                ", demand=" + Arrays.toString(demand) +
                ", cost=" + Arrays.toString(cost) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return Arrays.equals(sources, problem.sources) && Arrays.equals(destinations, problem.destinations) && Arrays.equals(supply, problem.supply) && Arrays.equals(demand, problem.demand) && Arrays.equals(cost, problem.cost);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(sources);
        result = 31 * result + Arrays.hashCode(destinations);
        result = 31 * result + Arrays.hashCode(supply);
        result = 31 * result + Arrays.hashCode(demand);
        result = 31 * result + Arrays.hashCode(cost);
        return result;
    }
}