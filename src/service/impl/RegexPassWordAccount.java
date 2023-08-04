package service.impl;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexPassWordAccount {

    public  static Boolean AccountPassWord(){
        boolean check=false;
        Scanner scanner =new Scanner(System.in);
        String account = "";
        String account1 ="hoan1995";
        String password = "";
        String password1 ="hoan95bn";
        while (true){
            System.out.println("Input Account :");
            account =scanner.nextLine();
            System.out.println("Input Password :");
            password =scanner.nextLine();
            Pattern pattern =Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
            if(pattern.matcher(account).matches()&&pattern.matcher(password).matches()&& account.equals(account1)&&password.equals(password1)){
                check =true;
                break;
            }else {
                System.out.println("Input Error");
            }
        }
        return check;
    }
}

