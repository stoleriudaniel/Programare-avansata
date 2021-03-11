package Laborator3;

import java.time.LocalTime;

public class Lab3 {
    public static void main(String[] args)
    {
        Hotel v1 = new Hotel();
        v1.setName("Hotel");
        Museum v2 = new Museum();
        v2.setName("Museum A");
        Museum v3 = new Museum();
        v2.setName("Museum B");
        Church v4 = new Church();
        v4.setName("Church A");
        Church v5 = new Church();
        v5.setName("Church B");
        Restaurant v6 = new Restaurant();
        v6.setName("Restaurant");
        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,10);
        v3.setCost(v4,20);
        v4.setCost(v5,30);
        v4.setCost(v6,10);
        v5.setCost(v6,20);
        /*
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
         */
        City c = new City();
        c.addLocation(v1);
        c.addLocation(v2);
        c.addLocation(v3);
        c.addLocation(v4);
        c.addLocation(v5);
        c.addLocation(v6);
        for(Location loc : c.getNodes())
            if((loc instanceof Visitable) && !(loc instanceof Payable))
                System.out.println(loc);
        System.out.println(v4.getClosingTime());
        v4.setOpeningTime(LocalTime.of(10,00));
        System.out.println(Visitable.getVisitingDuration(v5));
        TravelPlan travelPlan = new TravelPlan(c);
        System.out.println(travelPlan.getNodes());
    }
}
