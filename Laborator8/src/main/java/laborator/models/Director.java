package laborator.models;

public class Director {
    private int id;
    private String fistName;
    private String lastName;
    public Director(){}

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getFistName() {
        return fistName;
    }
}
