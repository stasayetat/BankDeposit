package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.DataInput;
import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SearchOption implements MainMenuCommand {
    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        List<String> searchPatternList = createArr();
        Scanner sc = new Scanner(System.in);
        System.out.println("Виберіть за яким параметром буде відбуватись пошук: ");
        int searchPattern = choosePattern(searchPatternList);
        List<DefaultDeposit> resSearchDeposit = searchDeposit(searchPattern, listDeposit);
        Logger logger = Logger.getLogger("MyLog");
        logger.info("Пошук в масиві");
    }
    protected List<DefaultDeposit> searchDeposit(Integer searchPattern, List<DefaultDeposit> searchList){
        List<DefaultDeposit> resDeposit = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        switch (searchPattern) {
            case 1 -> {
                System.out.println("Введіть назву компанії: ");
                String searchText = sc.nextLine();
                searchList.stream()
                        .filter(p -> p.getCompanyName().startsWith(searchText))
                        .forEach(p -> {
                            System.out.println(p);
                            resDeposit.add(p);
                        });
            }
            case 2 -> {
                System.out.println("Введіть назву депозиту: ");
                String searchText = sc.nextLine();
                searchList.stream()
                        .filter(p -> p.getDepositName().startsWith(searchText))
                        .forEach(p -> {
                            System.out.println(p);
                            resDeposit.add(p);
                        });
            }
            case 3 -> {
                System.out.println("Введіть відсотки: ");
                Double searchDouble = sc.nextDouble();
                searchList.stream()
                        .filter(p -> p.getPercentage().equals(searchDouble))
                        .forEach(p -> {
                            System.out.println(p);
                            resDeposit.add(p);
                        });
            }
            case 4 -> {
                System.out.println("Введіть кількість грошей: ");
                Integer searchInt = sc.nextInt();
                searchList.stream()
                        .filter(p -> p.getAmountMoney().equals(searchInt))
                        .forEach(p -> {
                            System.out.println(p);
                            resDeposit.add(p);
                        });
            }
            default -> {
            }
        }
        return resDeposit;
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
        DataInput dpi = new DataInput();
        for (String strPat : searchList) {
            System.out.println(strPat);
        }
        searchPattern = dpi.inputMore(searchList.size());
        searchList.get(searchPattern-1);
        return searchPattern;
    }
}
