package Laborator3;

import java.time.LocalTime;

public class Church extends Location implements Visitable{
    private LocalTime openingTime, closingTime;
    public Church(){
        this.openingTime=defaultOpeningTime();
        this.closingTime=defaultClosingTime();
    }
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }
    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    @Override
    public String toString() {
        return "Church{" +
                "cost=" + cost +
                '}';
    }
}
