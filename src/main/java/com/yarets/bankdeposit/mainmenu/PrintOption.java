package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class PrintOption implements MainMenuCommand {
    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        System.out.println("Всі підключені депозити:");
        for(int i = 0; i < listDeposit.size(); i++){
            System.out.println(i+1 + ":" + listDeposit.get(i).printString());
        }
        Logger logger = Logger.getLogger("MyLog");
        logger.info("Виводимо інформацію");
    }
}

