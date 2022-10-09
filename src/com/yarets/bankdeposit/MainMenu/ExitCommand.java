package com.yarets.bankdeposit.MainMenu;

public class ExitCommand implements MainMenuCommand {

    @Override
    public void doCommand() {
        System.exit(0);
    }
}
