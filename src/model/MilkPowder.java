package model;

import service.DisCount;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MilkPowder extends Milk implements DisCount {
    private static long serialUID = 12345678;
    private double weigh ;

    public MilkPowder() {
    }

    public MilkPowder( String name, double price, int quantity, LocalDate manufacturingDate , double weigh,Category category) {
        super( name, price, quantity, manufacturingDate, category);
        this.weigh = weigh;
    }

    public double getWeigh() {
        return weigh;
    }

    public void setWeigh(double weigh) {
        this.weigh = weigh;
    }

    @Override
    public double getAmount() {
        return getPrice()*getQuantity();
    }

    @Override
    public LocalDate getExpiry() {
        setManufacturingDate(getManufacturingDate().plusYears(2));
        return getManufacturingDate();
    }

    @Override
    public double getReadMoney() {
        long month = ChronoUnit.MONTHS.between(LocalDate.now(),getExpiry());
        if(month>=2&&month<=3){
            System.out.println("Sale of 30%");
            return getAmount()*70/100;
        }else  if(month>=4&&month<=5){
            System.out.println("Sale of 20%");
            return getAmount()*80/100;
        }else {
            System.out.println("Sale of 10%");
            return getAmount()*90/100;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "weigh=" + weigh +
                '}';
    }
}
