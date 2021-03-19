package laborator;

public class StudentScore extends Student{
    private int score;
    public StudentScore(){}
    public StudentScore(String name, int score){
        this.name=name;
        this.score=score;
    }

    @Override
    public String getName() {
        if(name==null)
        {
            throw new IllegalArgumentException("Null??");
        }
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "name=" + name +
                ", score=" + score +
                '}';
    }
}
