package model;

import java.io.Serializable;

public class Category implements Serializable {

    private static long serialUID = 12345678;
    private  int id ;
    private String name;
    public static int Index =0;

    public Category() {
    }

    public Category(String name) {
        this.id =++Index;
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
