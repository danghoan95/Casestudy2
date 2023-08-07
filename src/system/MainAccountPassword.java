package system;

import service.impl.RegexPassWordAccount;

import java.util.Scanner;

public  class MainAccountPassword {


    public static void main(String[] args) {

        System.out.println("Login :");
        if (RegexPassWordAccount.AccountPassWord()) {
            System.out.println("Logged in successfully");
          Main1.menu();
        }else {
            System.out.println("Error");
        }
    }
}
