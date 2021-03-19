package laborator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem {
    protected Student students[];
    protected School schools[];
    protected Map<Student,List<School>> stdPrefMap;
    protected Map<School,List<Student>> hPrefMap;
    public Problem(){}
    public Problem(Student students[], School schools[], Map<Student,List<School>> stdPrefMap, Map<School,List<Student>> hPrefMap){
        this.students=students;
        this.schools=schools;

        this.stdPrefMap=stdPrefMap;
        this.hPrefMap=hPrefMap;
    }
    public void show(){
        for(Student s : students)
            System.out.println(s);
        for(School h : schools)
            System.out.println(h);
        System.out.println(stdPrefMap);
        System.out.println(hPrefMap);
    }

    public void sethPrefMap(Map<School, List<Student>> hPrefMap) {
        this.hPrefMap = hPrefMap;
    }

    public void setSchools(School[] schools) {
        this.schools = schools;
    }

    public void setStdPrefMap(Map<Student, List<School>> stdPrefMap) {
        this.stdPrefMap = stdPrefMap;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Map<School, List<Student>> getHPrefMap() {
        return hPrefMap;
    }

    public Map<Student, List<School>> getStdPrefMap() {
        return stdPrefMap;
    }

    public School[] getSchools() {
        return schools;
    }

    public Student[] getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "students=" + Arrays.toString(students) +
                ", schools=" + Arrays.toString(schools) +
                ", stdPrefMap=" + stdPrefMap +
                ", hPrefMap=" + hPrefMap +
                '}';
    }
}
