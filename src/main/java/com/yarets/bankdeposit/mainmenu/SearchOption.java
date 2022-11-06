package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.util.*;

public class SearchOption implements MainMenuCommand {
    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        List<String> searchList = createArr();
        Scanner sc = new Scanner(System.in);
        System.out.println("Виберіть за яким параметром буде відбуватись пошук: ");
        int searchPattern = choosePattern(searchList);
        switch (searchPattern) {
            case 1 -> {
                System.out.println("Введіть назву компанії: ");
                String searchText = sc.nextLine();
                listDeposit.stream()
                        .filter(p -> p.getCompanyName().startsWith(searchText))
                        .forEach(p -> System.out.println(p));
            }
            case 2 -> {
                System.out.println("Введіть назву депозиту: ");
                String searchText = sc.nextLine();
                listDeposit.stream()
                        .filter(p -> p.getDepositName().startsWith(searchText))
                        .forEach(p -> System.out.println(p));
            }
            case 3 -> {
                System.out.println("Введіть відсотки: ");
                Double searchDouble = sc.nextDouble();
                listDeposit.stream()
                        .filter(p -> p.getPercentage().equals(searchDouble))
                        .forEach(p -> System.out.println(p));
            }
            case 4 -> {
                System.out.println("Введіть кількість грошей: ");
                Integer searchInt = sc.nextInt();
                listDeposit.stream()
                        .filter(p -> p.getAmountMoney().equals(searchInt))
                        .forEach(p -> System.out.println(p));
            }
            default -> {
            }
        }
    }


    protected List<String> createArr(){
        List<String> patternList = new LinkedList<>();
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
