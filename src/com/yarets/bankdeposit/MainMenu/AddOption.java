package com.yarets.bankdeposit.MainMenu;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class AddOption extends ChooseOption implements MainMenuCommand {
    public AddOption() {
    }
    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        Scanner sc = new Scanner(System.in);
        boolean goodData = false;
        double ownPer = 0;
        while (!goodData){
            try{
                System.out.println("Виберіть відсоток для власного депозиту:");
                ownPer = sc.nextDouble();
                goodData = true;
            }
            catch (InputMismatchException ex){
                System.out.println("Введена неправильна команда");
                sc.next();
            }
        }

        DefaultDeposit ownDeposit = DefaultDeposit.builder()
                .setDepositName("User Deposit")
                .setCompanyName("User Company")
                .setPercentage(ownPer)
                .build();
        setDeposit(ownDeposit);
        listDeposit.add(ownDeposit);
        ownDeposit.calcInvest();
    }



}
