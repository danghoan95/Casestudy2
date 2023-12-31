package system;

import service.impl.CategoryManage;
import service.impl.MilkManage;

import java.util.Scanner;

public class Main1 {
    public static void menu() {
        Scanner scanner =new Scanner(System.in);
        CategoryManage categoryManage =CategoryManage.getInstance(scanner);
        CategoryMain categoryMain =new CategoryMain();
        MilkMain milkMain =new MilkMain();
        MilkManage milkManage =new MilkManage(scanner,categoryManage);
        int choice =-1;
        do {
            System.out.println("Menu");
            System.out.println("1. Menu category");
            System.out.println("2. Menu Milk");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
           try{
               choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    categoryMain.menu();
                    break;
                case 2:
                    milkMain.menu(milkManage);
                    break;
            }
           }
        catch (Exception e){
            System.out.println("-----------");;
        }
        } while (choice!=0);
    }

}
