package Laborator;

import java.util.Arrays;
import java.util.Objects;

import static Laborator.SourceType.FACTORY;
import static Laborator.SourceType.WAREHOUSE;

public class Lab2 {
    public static void main(String[] args)
    {
        Source s1 = new Source("S1",FACTORY);
        Source s2 = new Source("S2",WAREHOUSE);
        Source s3 = new Source("S3",WAREHOUSE);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        Destination d1 = new Destination("D1");
        Destination d2 = new Destination("D2");
        Destination d3 = new Destination("D3");

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        //Problem pb = new Problem();
        Problem pb = new Problem(new Source[]{s1,s2,s3},new Destination[]{d1,d2,d3},new int[]{10,35,25},new int[]{20,25,25},new int[][]{{2,3,1},{5,4,8},{5,6,8}});
        System.out.println(pb);
    }
}