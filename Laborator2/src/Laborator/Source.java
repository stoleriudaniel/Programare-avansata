package Laborator;

import java.util.Objects;

public class Source{
    private String name;
    private SourceType type;
    public Source(){

    }
    public Source(String name, SourceType type){
        this.name=name;
        this.type=type;
    }

    public void setName(String name) {
        if(name==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        this.name = name;
    }

    public String getName() {
        if(name==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return name;
    }

    public void setType(SourceType type) {
        if(type==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        this.type = type;
    }

    public SourceType getType() {
        if(type==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(name, source.name) && type == source.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}