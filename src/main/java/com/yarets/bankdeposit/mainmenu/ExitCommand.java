package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ExitCommand implements MainMenuCommand {

    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        Logger logger = Logger.getLogger("MyLog");
        logger.info("Програма закрилась");
        System.exit(0);
    }
}
