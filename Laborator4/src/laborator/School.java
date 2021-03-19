package laborator;

public class School implements Comparable<School>{
    private String name;
    private int capacity;
    public School(){}
    public School(String name){
        this.name=name;
    }
    public School(String name, int capacity)
    {
        this.name=name;
        this.capacity=capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        if(name==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(School o) {
        if(name==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return this.name.compareTo(o.name);
    }
}
