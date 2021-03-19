package laborator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lab4 {
    public static void main(String[] args){
        var students = IntStream.rangeClosed(0,3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        List<Student> studentList = new LinkedList<>();

        List<Student> newSortedList = studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        for (Student s : students) {
            studentList.add(s);
        }
        var h = IntStream.rangeClosed(0,2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new);

        Set<School> schoolSet = new TreeSet<>();
        schoolSet.add(h[0]);
        schoolSet.add(h[1]);
        schoolSet.add(h[2]);

        Map<Student, List<School>> stdPrefMap = new HashMap<>();

        stdPrefMap.put(students[0],Arrays.asList(h[0], h[1], h[2]));
        stdPrefMap.put(students[1],Arrays.asList(h[0], h[1], h[2]));
        stdPrefMap.put(students[2],Arrays.asList(h[0],h[1]));
        stdPrefMap.put(students[3],Arrays.asList(h[0],h[2]));

        Map<School, List<Student>> hPrefMap = new TreeMap<>();

        hPrefMap.put(h[0],Arrays.asList(students[3],students[0],students[1],students[2]));
        hPrefMap.put(h[1],Arrays.asList(students[0],students[2],students[1]));
        hPrefMap.put(h[2],Arrays.asList(students[0],students[1],students[3]));

        System.out.println(stdPrefMap);
        System.out.println(hPrefMap);
        Problem pb = new Problem(students,h,stdPrefMap,hPrefMap);
        //pb.show();
        List<School> target = Arrays.asList(h[0], h[1]);
        studentList.stream()
                .filter(std -> stdPrefMap.get(std).containsAll(target))
                .forEach(System.out::println);

    }
}
