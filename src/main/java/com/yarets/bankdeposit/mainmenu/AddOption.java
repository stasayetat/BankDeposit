package com.yarets.bankdeposit.mainmenu;


import com.yarets.bankdeposit.DataInput;
import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AddOption extends ChooseOption implements MainMenuCommand {
    private Logger logger = Logger.getLogger("MyLog");
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
        logger.info("Додано депозит " + ownDeposit.getDepositName());
    }
}
