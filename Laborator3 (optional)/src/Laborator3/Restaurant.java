package Laborator3;

import java.time.LocalTime;

public class Restaurant extends Location implements Visitable, Payable{
    private LocalTime openingTime, closingTime;
    private double ticketPrice;
    public Restaurant(){
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

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "cost=" + cost +
                '}';
    }
}
