package system;

import model.Category;
import service.impl.MilkManage;

import java.util.Scanner;

public class MilkMain {
    public void menu(MilkManage milkManage) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Add milk");
            System.out.println("2. Update milk");
            System.out.println("3. Display all milk");
            System.out.println("4. Display search milk name");
            System.out.println("5. Display  milk price min");
            System.out.println("6. Display  milk price max");
            System.out.println("7. Display search  milk price");
            System.out.println("8. Display  milk category");
            System.out.println("9. Delete Milk");
            System.out.println("10. Display DisCount : ");
            System.out.println("11. Display Sum Milk : ");
            System.out.println("12. DeleteCategory : ");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    milkManage.create();
                    break;
                case 2:
                    milkManage.update();
                    break;
                case 3:
                    milkManage.display();
                    break;
                case 4:
                    milkManage.searchByName();
                    break;
                case 5:
                    milkManage.displayMinPrice();
                    break;
                case 6:
                    milkManage.displayMaxPrice();
                    break;
                case 7:
                    milkManage.searchByPrice();
                    break;
                case 8:
                    milkManage.displayByCategory(new Category());
                    break;
                case 9:
                    milkManage.deleteById();
                    break;
                case 10:
                    milkManage.displayDisCount();
                    break;
                case 11:
                    milkManage.displaySumMilk();
                    break;
                case 12:
                    milkManage.deleteProductCategory();
                    break;
            }
        } while (choice != 0);
    }
}

