package registeranaccount;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterManager {
    private final Scanner scanner;
    
    private Pattern pattern;
    

    public RegisterManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void Login() {
        System.out.println("Login :");
        System.out.println("Enter Username : ");
         pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        String name = scanner.nextLine();
        if(validate(name)){
            System.out.println("Enter successfully ");
        }else {
            System.out.println("Please re-enter");
        }
        System.out.println("Enter Password : ");
        pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        String password = scanner.nextLine();
        if(validate(password)){
            System.out.println("Enter successfully");
        }
        else {
            System.out.println("Please re-enter");
        }
        System.out.println("Enter Email : ");
        pattern =Pattern.compile("^[a-z][a-z0-9_.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$");
        String Email = scanner.nextLine();
        if(validate(Email)){
            System.out.println("Enter successfully ");
        }else {
            System.out.println("Please re-enter");
        }
        System.out.println("Enter Phone : ");
        pattern =Pattern.compile("^0\\d{10}$");
        String numberPhone = scanner.nextLine();
        if (validate(numberPhone)){
            System.out.println("Enter successfully ");
        }else {
            System.out.println("Please re-enter");
        }
        System.out.println("Enter Address : ");
        String Address = scanner.nextLine();
        System.out.println("Logged in successfully : ");
    }

    public boolean validate(String regex) {
       Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
