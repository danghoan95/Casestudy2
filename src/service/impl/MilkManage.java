package service.impl;

import IO.IOFile;
import model.Category;
import model.FreshMilk;
import model.Milk;
import model.MilkPowder;
import service.IMilkService;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MilkManage implements IMilkService, IOFile<Milk> {
    public List<Milk> getMilkList() {
        return milkList;
    }

    private final List<Milk> milkList;
    private final Scanner scanner;
    private final CategoryManage categoryManage;
    private final String PATH = "soc.txt";

    public MilkManage(Scanner scanner, CategoryManage categoryManage) {
        milkList = read(PATH);
        this.scanner = scanner;
        this.categoryManage = categoryManage;
        setIndex();
    }

    private void setIndex() {
        if (!milkList.isEmpty()) {
            int index = milkList.get(0).getId();
            for (Milk milk : milkList) {
                if (milk.getId() > index) {
                    index = milk.getId();
                }
            }
            Milk.Index = index;
        } else {
            Milk.Index = 0;
        }
    }

    private MilkPowder getMilkPowder() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Date");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter Weight");
        double weight = Double.parseDouble(scanner.nextLine());
        categoryManage.display();
        System.out.println("Enter Category :");
        Category category = categoryManage.findById();
        return new MilkPowder(name, price, quantity, date, weight, category);
    }

    private FreshMilk getFreshMilk() {
        System.out.println("Enter name : ");
        String name = scanner.nextLine();
        System.out.println("Enter price ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Date");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter Volume");
        double volume = Double.parseDouble(scanner.nextLine());
        categoryManage.display();
        System.out.println("Enter Category :");
        Category category = categoryManage.findById();
        return new FreshMilk(name, price, quantity, date, volume, category);
    }

    @Override
    public void deleteById() {
        Milk milk = findById();
        if (milkList != null) {
            milkList.remove(milk);
        } else {
            System.out.println("Not exist category have this id!");
        }
        write(milkList, PATH);
    }

    public void deleteCategory() {
        categoryManage.display();
        List<Milk> milkList1 = new ArrayList<>();
        Category category =categoryManage.findById();
       for (Milk milk: milkList){
           if(milk.getCategory().getId()==category.getId()){
               milkList1.add(milk);
           }
       }
       for (Milk milk :milkList1){
           System.out.println(milk);
       }

    }


    @Override
    public void displayMaxPrice() {
        if (!milkList.isEmpty()) {
            double max = milkList.get(0).getPrice();
            for (Milk milk : milkList) {
                if (milk.getPrice() > max) {
                    max = milk.getPrice();
                }
            }
            for (Milk milk : milkList) {
                if (milk.getPrice() == max) {
                    System.out.println(milk);
                }
            }

        } else {
            System.out.println("Not exist product in list!");
        }

    }

    @Override
    public void displayMinPrice() {
        if (!milkList.isEmpty()) {
            double min = milkList.get(0).getPrice();
            for (Milk milk : milkList) {
                if (milk.getPrice() < min) {
                    min = milk.getPrice();
                }
            }
            for (Milk milk : milkList) {
                if (milk.getPrice() == min) {
                    System.out.println(milk);
                }
            }

        } else {
            System.out.println("Not exist milk in list!");
        }

    }

    @Override
    public void searchByName() {
        Boolean check = false;
        System.out.println("Enter name :");
        String name = scanner.nextLine();
        for (Milk milk : milkList) {
            if (milk.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(milk);
                check = true;
            }

        }
        if (!check) {
            System.out.println("Not exist milk");
        }
    }

    @Override
    public void searchByPrice() {
        System.out.println("Enter min :");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter max :");
        double max = Double.parseDouble(scanner.nextLine());
        for (Milk milk : milkList) {
            if (milk.getPrice() > min && milk.getPrice() < max) {
                System.out.println(milk);
            }
        }

    }

    @Override
    public void displayByCategory(Category category) {
        categoryManage.display();
        System.out.println("Enter idCategory :");
        int idCategory = Integer.parseInt(scanner.nextLine());
        for (Milk milk : milkList) {
            if (milk.getCategory().getId() == idCategory) {
                System.out.println(milk);
            }
        }

    }

    @Override
    public void create() {
        int choie;
        do {
            System.out.println("1.Enter FreshMilk");
            System.out.println("2.Enter MilkPowder");
            System.out.println("0.Exit");
            choie = Integer.parseInt(scanner.nextLine());
            switch (choie) {
                case 1:
                    System.out.println("Enter FreshMilk");
                    milkList.add(getFreshMilk());
                    break;
                case 2:
                    System.out.println("Enter MilkPowder");
                    milkList.add(getMilkPowder());
                    break;
            }
            write(milkList, PATH);
        } while (choie != 0);
    }

    @Override
    public void update() {
        int choie;
        do {
            System.out.println("1.Update MilkPower :");
            System.out.println("2.Update FreshMilk :");
            System.out.println("0.Exit :");
            choie = Integer.parseInt(scanner.nextLine());
            switch (choie) {
                case 1:
                    System.out.println("Update MilkPower :");
                    updateMilkPowder();
                    break;
                case 2:
                    System.out.println("Update FreshMilk :");
                    updateFreshMilk();
            }
            write(milkList, PATH);

        } while (choie != 0);
    }

    public void updateMilkPowder() {
        Milk milk = findById();
        if (milk != null) {
            System.out.println("Enter name :");
            milk.setName(scanner.nextLine());
            ;
            System.out.println("Enter price :");
            milk.setPrice(Double.parseDouble(scanner.nextLine()));
            ;
            System.out.println("Enter quantity");
            milk.setQuantity(Integer.parseInt(scanner.nextLine()));
            System.out.println("Enter date");
            Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
            String date = scanner.nextLine();
            if (pattern.matcher(date).matches()) {
                try {
                    milk.setManufacturingDate(LocalDate.parse(date));
                } catch (DateTimeParseException e) {
                    e.printStackTrace();
                }


            } else {
                System.out.println("Enter incorrectly and then re-enter");
            }
            System.out.println("Enter Weight");
            if (milk instanceof MilkPowder) {
                ((MilkPowder) milk).setWeigh(Double.parseDouble(scanner.nextLine()));
            }
            categoryManage.display();
            System.out.println("Enter Category");
            Category category = categoryManage.findById();
            write(milkList, PATH);

        }

    }

    public void updateFreshMilk() {
        Milk milk = findById();
        if (milk != null) {
            System.out.println("Enter name :");
            milk.setName(scanner.nextLine());
            ;
            System.out.println("Enter price :");
            milk.setPrice(Double.parseDouble(scanner.nextLine()));
            ;
            System.out.println("Enter quantity");
            milk.setQuantity(Integer.parseInt(scanner.nextLine()));
            System.out.println("Enter date");
            Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
            String date = scanner.nextLine();
            if (pattern.matcher(date).matches()) {
                try {
                    milk.setManufacturingDate(LocalDate.parse(date));
                } catch (DateTimeParseException e) {
                    e.printStackTrace();
                }


            } else {
                System.out.println("Enter incorrectly and then re-enter");
            }
            System.out.println("Enter Volume");
            if (milk instanceof FreshMilk) {
                ((FreshMilk) milk).setVolume(Double.parseDouble(scanner.nextLine()));
            }
            categoryManage.display();
            System.out.println("Enter Category");
            Category category = categoryManage.findById();
            write(milkList, PATH);

        }

    }

    @Override
    public void display() {
        if (!milkList.isEmpty()) {
            for (Milk product : milkList) {
                System.out.println(product);
            }
        } else {
            System.out.println("Not exist product in list!");
        }
    }

    @Override
    public Milk findById() {
        System.out.println("Input id : ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Milk milk : milkList) {
            if (milk.getId() == id) {
                return milk;
            }
        }
        return null;
    }

    public void displayDisCount() {
        Milk milk = findById();
        if (milk instanceof FreshMilk) {
            System.out.println("Discount Price FreshMilk : ");
            System.out.println(((FreshMilk) milk).getAmount());
            System.out.println(((FreshMilk) milk).getReadMoney());
        }
        if (milk instanceof MilkPowder) {

            System.out.println("Discount Price MilkPowder");
            System.out.println(((MilkPowder) milk).getAmount());
            System.out.println(((MilkPowder) milk).getReadMoney());
        }
    }

    public void displaySumMilk() {
        double sum = 0;
        for (Milk milk : milkList) {
            if (milk instanceof MilkPowder) {
                sum += ((MilkPowder) milk).getAmount();
            } else {
                sum += ((FreshMilk) milk).getAmount();
            }
        }
        String number = String.format("%010.1f", sum);
        System.out.println(number);
    }


    @Override
    public void write(List<Milk> milkList, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(milkList);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Milk> read(String path) {
        List<Milk> milks = new ArrayList<>();
        File file = new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream obj = new ObjectInputStream(fileInputStream);
            if (obj.available() != -1) {
                milks = (List<Milk>) obj.readObject();
            }
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return milks;
    }

}



