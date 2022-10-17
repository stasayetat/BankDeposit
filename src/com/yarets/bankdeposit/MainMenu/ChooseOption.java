package com.yarets.bankdeposit.MainMenu;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;
import com.yarets.bankdeposit.ListOfCurrency;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ChooseOption implements MainMenuCommand {
    protected List<DefaultDeposit> patternDeposit = new ArrayList<>();
    public ChooseOption() {
        createSomeDeposit();
    }

    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        DefaultDeposit curDeposit = new DefaultDeposit();
        boolean goodData = false;
        System.out.println("Виберіть один з наявних депозитів: ");
        for(int i = 0; i < patternDeposit.size(); i++){
            System.out.println(i+1 + ":" + patternDeposit.get(i));
        }
        Scanner sc = new Scanner(System.in);

        while (!goodData){
            try{
                System.out.println("Введіть індекс обраного депозиту");
                int indDep = sc.nextInt();
                curDeposit = patternDeposit.get(indDep-1);
                goodData = true;
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Введена неправильна команда");
            }
        }
        setDeposit(curDeposit);
        listDeposit.add(curDeposit);
        curDeposit.calcInvest();
    }

    protected void setDeposit(DefaultDeposit curDeposit){
        Scanner sc = new Scanner(System.in);
        boolean goodData = false;
        int tmpValue;
        do {
            System.out.println("Введіть кількість грошей, які плануєте покласти на депозит:");
            tmpValue = sc.nextInt();
        }while(curDeposit.getMinInvestMoney() > tmpValue);
        curDeposit.setAmountMoney(tmpValue);
        while (!goodData){
            try{
                System.out.println("Введіть кількість часу для депозиту(у місяцях):");
                tmpValue = sc.nextInt();

                goodData = true;
            }
            catch (InputMismatchException ex){
                System.out.println("Введена неправильна команда");
                sc.next();
            }
        }
        curDeposit.setTermOfDeposit(tmpValue);
        goodData = false;

        while (!goodData){
            try{
                System.out.println("Введіть чи плануєте ви вносити ще грощі щомісячно?(Так - 1, Ні - 0)");
                tmpValue = sc.nextInt();
                if(tmpValue == 1){
                    System.out.println("Введіть кількість грошей, на які буде збільшуватись депозит:");
                    tmpValue = sc.nextInt();
                    curDeposit.setAmountMonthlyAdd(tmpValue);
                }
                goodData = true;
            }
            catch (InputMismatchException ex){
                System.out.println("Введена неправильна команда");
                sc.next();
            }
        }
        goodData = false;
        ListOfCurrency curCurrency = ListOfCurrency.UAH;
        while (!goodData){
            try{
                System.out.println("Виберіть валюту для депозиту, якщо вибрано не UAH то відсоток у 10 раз менше:");
                for(ListOfCurrency ctn : ListOfCurrency.values()){
                    System.out.println(ctn);
                }
                String tmpStr = sc.next();
                curCurrency = ListOfCurrency.valueOf(tmpStr);
                goodData = true;
            }
            catch (IllegalArgumentException ex){
                System.out.println("Введена неправильна команда");
            }
        }
        curDeposit.setCurrency(curCurrency);
        goodData = false;
        return;
    }

    private void createSomeDeposit() {
        DefaultDeposit defDeposit = DefaultDeposit.builder()
                .setDepositName("Молодіжний")
                .setCompanyName("Alfa-bank")
                .setEarlyTerm(true)
                .setPercentage(6.5)
                .build();
        patternDeposit.add(defDeposit);
        defDeposit = DefaultDeposit.builder()
                .setDepositName("Велика Банка")
                .setCompanyName("PrivatBank")
                .setEarlyTerm(true)
                .setPercentage(14.0)
                .setMinInvestMoney(10000)
                .build();
        patternDeposit.add(defDeposit);
        defDeposit = DefaultDeposit.builder()
                .setDepositName("Швидкі гроші")
                .setCompanyName("Pumb")
                .setEarlyTerm(true)
                .setPercentage(9.0)
                .setMinInvestMoney(10)
                .build();
        patternDeposit.add(defDeposit);
    }
}
