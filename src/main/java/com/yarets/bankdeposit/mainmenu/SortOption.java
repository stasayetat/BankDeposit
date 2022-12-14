package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.DataInput;
import com.yarets.bankdeposit.comparator.AmountMoneyComparator;
import com.yarets.bankdeposit.comparator.CompanyNameComparator;
import com.yarets.bankdeposit.comparator.DepositNameComparator;
import com.yarets.bankdeposit.comparator.PercentageComparator;
import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
        sortDeposit(sortPattern, listDeposit);
        Logger logger = Logger.getLogger("MyLog");
        logger.info("Сортуємо масив");
    }
    private void sortDeposit(Integer sortPattern, List<DefaultDeposit> listDeposit){
        DataInput dpi = new DataInput();
        System.out.println("Виберіть за зростанням чи за спаданням(0 та 1 відповідно):");
        int ascDesc = dpi.inputOneZero();
        switch (sortPattern) {
            case 1 -> {
                listDeposit.sort(new CompanyNameComparator());
                if(ascDesc == 1)
                    Collections.reverse(listDeposit);
            }
            case 2 -> {
                listDeposit.sort(new DepositNameComparator());
                if(ascDesc == 1)
                    Collections.reverse(listDeposit);
            }
            case 3 -> {
                listDeposit.sort(new PercentageComparator());
                if(ascDesc == 1)
                    Collections.reverse(listDeposit);
            }
            case 4 -> {
                listDeposit.sort(new AmountMoneyComparator());
                if(ascDesc == 1)
                    Collections.reverse(listDeposit);
            }
            default -> System.out.println("Вибрана неправильна команда");
        }
    }
}