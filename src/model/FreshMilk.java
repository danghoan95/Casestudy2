package model;

import service.DisCount;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FreshMilk extends Milk implements DisCount {
    private static long serialUID = 12345678;
    private double volume;

    public FreshMilk() {
    }

    public FreshMilk(String name, double price, int quantity, LocalDate manufacturingDate, double volume, Category category) {
        super(name, price, quantity, manufacturingDate, category);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public double getAmount() {
        return getPrice() * getQuantity();
    }

    @Override
    public LocalDate getExpiry() {
        setManufacturingDate(getManufacturingDate().plusMonths(6));
        return getManufacturingDate();
    }

    @Override
    public double getReadMoney() {
        long day = ChronoUnit.DAYS.between(LocalDate.now(), getExpiry());
        if (day < 30) {
            System.out.println("Sale of 20%");
            return getAmount() * 80/100;
        }else {
            System.out.println("Sale of 10%");
            return  getAmount() *90/100;
        }

    }

    @Override
    public String toString() {
        return super.toString() +
                "volume=" + volume + "}"
                ;
    }
}
