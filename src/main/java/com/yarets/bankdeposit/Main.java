package com.yarets.bankdeposit;

import com.yarets.bankdeposit.mainmenu.MenuInit;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {


    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
        try{
            fh = new FileHandler("C:\\Users\\stasy\\IdeaProjects\\BankDeposit\\logger.txt");
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("Програма запустилась");
        Scanner scanner = new Scanner(System.in);
        MenuInit mainMenu = new MenuInit();
        while(true) {
            System.out.println("Введіть команду:");
            System.out.println("Доступні команди: " + mainMenu.printCommand());
            String command = scanner.next();
            mainMenu.doCommand(command);
        }
    }
}