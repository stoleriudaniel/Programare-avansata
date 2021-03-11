package Laborator3;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpeningTime();
    LocalTime getClosingTime();
    default LocalTime defaultOpeningTime(){
        return (LocalTime) LocalTime.of(9,30);
    }
    default LocalTime defaultClosingTime(){
        return (LocalTime) LocalTime.parse("20:00");
    }
    public static Duration getVisitingDuration(Visitable location){
        return (Duration) Duration.between(location.getOpeningTime(), location.getClosingTime());
    }
}
