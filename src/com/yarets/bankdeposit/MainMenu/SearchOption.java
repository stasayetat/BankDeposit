package com.yarets.bankdeposit.MainMenu;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;
import com.yarets.bankdeposit.MainMenu.MainMenuCommand;

import java.util.List;

public class SearchOption implements MainMenuCommand {
    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        System.out.println("Відбувається пошук");
    }
}
