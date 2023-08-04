package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public abstract class Milk implements Serializable {
    private static long serialUID = 12345678;
    public  static  int Index =0;
    private int id ;
    private String name;
    private double price;
    private int quantity;
     private LocalDate manufacturingDate; ;
     private  Category category ;

    public Milk() {
    }

    public Milk(String name, double price, int quantity, LocalDate manufacturingDate,Category category) {
        this.id =++Index;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturingDate = manufacturingDate;
        this.category = category;
    }

    public Milk(int id, String name, double price, int quantity, LocalDate manufacturingDate, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturingDate = manufacturingDate;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public abstract double getAmount();
    public abstract LocalDate getExpiry();


    @Override
    public String toString() {
        return "Milk{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", manufacturingDate=" + manufacturingDate +
                ", category=" + category +
                '}';
    }
}
