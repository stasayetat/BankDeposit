package com.yarets.bankdeposit.MainMenu;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddOption extends ChooseOption implements MainMenuCommand {
    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        Scanner sc = new Scanner(System.in);
        boolean goodData = false;
        double ownPerc = 0;
        while (!goodData){
            try{
                System.out.println("Виберіть відсоток для власного депозиту:");
                ownPerc = sc.nextDouble();
                goodData = true;
            }
            catch (InputMismatchException ex){
                System.out.println("Введена неправильна команда");
                sc.next();
            }
        }
        int tmpValue = 0;
        goodData = false;
        while (!goodData){
            try{
                System.out.println("Введіть чи плануєте ви забрати кошти достроково?(Так - 1, Ні - 0)");
                tmpValue = sc.nextInt();
                goodData = true;
            }
            catch (InputMismatchException ex){
                System.out.println("Введена неправильна команда");
                sc.next();
            }
        }

        boolean tmpEarly;
        if(tmpValue == 1){
            tmpEarly = true;
        }
        else
            tmpEarly = false;
        DefaultDeposit ownDeposit = DefaultDeposit.builder()
                .setDepositName("User Deposit")
                .setCompanyName("User Company")
                .setPercentage(ownPerc)
                .setEarlyTerm(tmpEarly)
                .build();
        setDeposit(ownDeposit);
        listDeposit.add(ownDeposit);
        ownDeposit.calcInvest();
    }

    public AddOption() {
    }

}
