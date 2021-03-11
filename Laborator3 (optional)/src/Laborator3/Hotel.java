package Laborator3;

import java.time.LocalTime;

public class Hotel extends Location implements Visitable, Payable{
    private LocalTime openingTime, closingTime;
    public Hotel(){
        this.openingTime=defaultOpeningTime();
        this.closingTime=defaultClosingTime();
    }
    @Override
    public double getTicketPrice() {
        return 0;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "cost=" + cost +
                '}';
    }
}
