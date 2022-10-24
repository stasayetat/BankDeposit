package com.yarets.bankdeposit.MainMenu;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;
import com.yarets.bankdeposit.MainMenu.MainMenuCommand;
import com.yarets.bankdeposit.comparator.AmountMoneyComparator;
import com.yarets.bankdeposit.comparator.CompanyNameComparator;
import com.yarets.bankdeposit.comparator.DepositNameComparator;
import com.yarets.bankdeposit.comparator.PercentageComparator;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortOption extends SearchOption implements MainMenuCommand {

    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        Scanner sc = new Scanner(System.in);
        int sortPattern = 0;
        boolean goodData = false;
        int ascDesc = 0;
        List<String> sortList = createArr();
        System.out.println("Виберіть за яким параметром буде відбуватись сортування:");
        sortPattern = choosePattern(sortList);
        while(!goodData) {
            try{
                System.out.println("Виберіть за зростанням чи за спаданням(0 та 1 відповідно):");
                ascDesc = sc.nextInt();
                if(ascDesc != 0 && ascDesc != 1){
                    throw new IllegalArgumentException();
                }
                goodData = true;
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Введено неправильна команда");
                continue;
            }
        }


        switch (sortPattern) {
            case 1:
                sortCompanyName(listDeposit, ascDesc);
                break;
            case 2:
                sortDepositName(listDeposit, ascDesc);
                break;
            case 3:
                sortPercentage(listDeposit, ascDesc);
                break;
            case 4:
                sortAmountMoney(listDeposit, ascDesc);
                break;
            default:
                System.out.println("Вибрана неправильна команда");
                break;
        }

    }

    private void sortCompanyName(List<DefaultDeposit> listDeposit, int ascDesc){
        Collections.sort(listDeposit, new CompanyNameComparator());
        if(ascDesc == 1)
            Collections.reverse(listDeposit);

    }

    private void sortDepositName(List<DefaultDeposit> listDeposit, int ascDesc){
        Collections.sort(listDeposit, new DepositNameComparator());
        if(ascDesc == 1)
            Collections.reverse(listDeposit);
    }

    private void sortPercentage(List<DefaultDeposit> listDeposit, int ascDesc){
        Collections.sort(listDeposit, new PercentageComparator());
        if(ascDesc == 1)
            Collections.reverse(listDeposit);
    }

    private void sortAmountMoney(List<DefaultDeposit> listDeposit, int ascDesc){
        Collections.sort(listDeposit, new AmountMoneyComparator());
        if(ascDesc == 1)
            Collections.reverse(listDeposit);
    }
}
























































