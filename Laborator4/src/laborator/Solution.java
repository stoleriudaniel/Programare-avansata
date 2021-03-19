package laborator;

import java.util.List;
import java.util.Map;

public class Solution {
    protected Map<Student,School> solutionMap;
    public Solution(){}
    public Solution(Map<Student,School> solutionMap){
        this.solutionMap=solutionMap;
    }
    public void show(){
        System.out.println(solutionMap);
    }

    public Map<Student, School> getSolutionMap() {
        return solutionMap;
    }

    public void setSolutionMap(Map<Student, School> solutionMap) {
        this.solutionMap = solutionMap;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "solutionMap=" + solutionMap +
                '}';
    }
}
