package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.DataInput;
import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.util.List;

public class CalcOption implements MainMenuCommand {

    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
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
    }
}