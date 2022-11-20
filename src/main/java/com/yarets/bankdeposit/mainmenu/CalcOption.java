package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.DataInput;
import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CalcOption implements MainMenuCommand {

    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        Logger logger = Logger.getLogger("MyLog");
        DefaultDeposit curDeposit = new DefaultDeposit();
        DataInput dpi = new DataInput();
        System.out.println("Виберіть депозит, який хочете порахувати:");
        if(listDeposit.size() == 0) {
            System.out.println("Немає чого рахувати :(");
            return;
        }

        for(int i = 0; i < listDeposit.size(); i++){
            System.out.println(i+1 + ":" + listDeposit.get(i));
        }
        int curDep = dpi.inputMore(listDeposit.size());
        curDeposit = listDeposit.get(curDep-1);
        curDeposit.calcInvest();
        logger.info("Депозит " + curDeposit.getDepositName() + " пораховано");
    }
}