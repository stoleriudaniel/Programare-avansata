package laborator;

import java.util.List;
import java.util.Map;

public class Algorithm {
    private Map<StudentScore, List<School>> stdPrefMap;
    private List<StudentScore> stdScoreList;
    private Map<School,List<StudentScore>> hStudents;
    private Map<StudentScore,School> solMap;
    public Algorithm(){}
    public Algorithm(Map<StudentScore, List<School>> stdPrefMap, List<StudentScore> stdScoreList){
        this.stdPrefMap=stdPrefMap;
        this.stdScoreList=stdScoreList;
    }
}
