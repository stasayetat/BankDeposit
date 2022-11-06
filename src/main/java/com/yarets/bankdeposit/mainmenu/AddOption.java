package com.yarets.bankdeposit.mainmenu;


import com.yarets.bankdeposit.DataInput;
import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.util.List;

public class AddOption extends ChooseOption implements MainMenuCommand {
    public AddOption() {
    }
    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        DataInput dpi = new DataInput();
        System.out.println("Виберіть відсоток для власного депозиту:");
        double ownPer = dpi.inputDouble();

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
