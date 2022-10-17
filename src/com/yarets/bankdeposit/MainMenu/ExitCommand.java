package com.yarets.bankdeposit.MainMenu;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;

import java.util.List;

public class ExitCommand implements MainMenuCommand {

    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        System.exit(0);
    }
}
