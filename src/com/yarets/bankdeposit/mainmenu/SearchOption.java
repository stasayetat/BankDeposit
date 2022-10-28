package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;

import java.util.*;

public class SearchOption implements MainMenuCommand {
    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        int searchPattern = 0;
        List<String> searchList = createArr();
        Scanner sc = new Scanner(System.in);
        System.out.println("Виберіть за яким параметром буде відбуватись пошук: ");
        searchPattern = choosePattern(searchList);
        switch (searchPattern) {
            case 1:
                searchCompanyName(listDeposit);
                break;
            case 2:
                searchDepositName(listDeposit);
                break;
            case 3:
                searchPercentage(listDeposit);
                break;
            case 4:
                searchAmountMoney(listDeposit);
                break;
            default:
                break;
        }


    }

    private void searchCompanyName(List<DefaultDeposit> listDeposit){
        boolean goodData = false;
        int chSearch = 0;
        Scanner sc = new Scanner(System.in);
        while(!goodData){
            try{
                System.out.println("Введіть назву компанії: ");
                String searchText = sc.nextLine();
                for (DefaultDeposit defDeposit : listDeposit){
                    if(defDeposit.getCompanyName().equals(searchText)) {
                        System.out.println(defDeposit.printString());
                        chSearch++;
                    }
                }
                if(chSearch == 0){
                    throw new IllegalArgumentException();
                }
                goodData = true;
                }
            catch (IllegalArgumentException ex) {
                System.out.println("Введено неправильна ім'я компанії");
                continue;
            }
    }
    }


    private void searchDepositName(List<DefaultDeposit> listDeposit) {
        boolean goodData = false;
        int chSearch = 0;
        Scanner sc = new Scanner(System.in);
        while (!goodData) {
            try {
                System.out.println("Введіть назву депозиту: ");
                String searchText = sc.nextLine();
                for (DefaultDeposit defDeposit : listDeposit) {
                    if (defDeposit.getDepositName().equals(searchText)) {
                        System.out.println(defDeposit.printString());
                        chSearch++;
                    }
                }
                if (chSearch == 0) {
                    throw new IllegalArgumentException();
                }
                goodData = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Введено неправильне ім'я депозиту");
                continue;
            }
        }
    }

    private void searchPercentage(List<DefaultDeposit> listDeposit){
        boolean goodData = false;
        int chSearch = 0;
        Scanner sc = new Scanner(System.in);
        while (!goodData) {
            try {
                System.out.println("Введіть відсотки: ");
                Double searchInt = sc.nextDouble();
                for (DefaultDeposit defDeposit : listDeposit) {
                    if (defDeposit.getPercentage().equals(searchInt)) {
                        System.out.println(defDeposit.printString());
                        chSearch++;
                    }
                }
                if (chSearch == 0) {
                    throw new IllegalArgumentException();
                }
                goodData = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Введено неправильні відсотки");
                continue;
            }
            catch (InputMismatchException ex){
                System.out.println("Введена неправильна команда");
                sc.next();
            }
        }
    }
    private void searchAmountMoney(List<DefaultDeposit> listDeposit){
        boolean goodData = false;
        int chSearch = 0;
        Scanner sc = new Scanner(System.in);
        while (!goodData) {
            try {
                System.out.println("Введіть кількість грошей: ");
                Integer searchInt = sc.nextInt();
                for (DefaultDeposit defDeposit : listDeposit) {
                    if (defDeposit.getAmountMoney().equals(searchInt)) {
                        System.out.println(defDeposit.printString());
                        chSearch++;
                    }
                }
                if (chSearch == 0) {
                    throw new IllegalArgumentException();
                }
                goodData = true;
            } catch (IllegalArgumentException ex) {
                System.out.println("Введено неправильна кількість грошей");
                continue;
            }
        }
    }

    protected List<String> createArr(){
        List<String> patternList = new ArrayList<>();
        patternList.add("1. Назва компанії");
        patternList.add("2. Назва депозиту");
        patternList.add("3. Кількість відсотків");
        patternList.add("4. Кількість грошей");
        return patternList;
    }

    protected Integer choosePattern(List<String> searchList){
        boolean goodData = false;
        int searchPattern = 0;
        Scanner sc = new Scanner(System.in);
        while(!goodData){
            try {
                for (String strPat : searchList) {
                    System.out.println(strPat);
                }
                searchPattern = sc.nextInt();
                searchList.get(searchPattern-1);
                goodData = true;
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Введена неправильна команда");
            }
        }
        return searchPattern;
    }
}
