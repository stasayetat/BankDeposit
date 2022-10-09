package com.yarets.bankdeposit.MainMenu;

import com.yarets.bankdeposit.MainMenu.MainMenuCommand;

public class SearchOption implements MainMenuCommand {
    @Override
    public void doCommand() {
        System.out.println("Відбувається пошук");
    }
}
