package com.yarets.bankdeposit;

import com.yarets.bankdeposit.MainMenu.MenuInit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuInit mainMenu = new MenuInit();
        System.out.println("Введіть команду:");
        System.out.println("Доступні команди: " + mainMenu.printCommand());
        while(true) {
            System.out.println("Введіть команду:");
            String command = scanner.next();
            mainMenu.doCommand(command);
        }
    }
}