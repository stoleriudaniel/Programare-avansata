package laborator;

public class Student implements Comparable<Student>{
    protected String name;
    public Student(){}
    public Student(String name){
        this.name=name;
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

    @Override
    public int compareTo(Student o) {
        if(name==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
