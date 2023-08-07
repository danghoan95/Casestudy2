package system;

import registeranaccount.RegisterManager;

import javax.jws.soap.SOAPMessageHandlers;
import java.util.Scanner;

public class MainLogin {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        RegisterManager registerManager =new RegisterManager(scanner);
        registerManager.Login();
    }
}
