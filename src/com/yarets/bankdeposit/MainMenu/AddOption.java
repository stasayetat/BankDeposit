package com.yarets.bankdeposit.MainMenu;

public class AddOption implements MainMenuCommand {
    @Override
    public void doCommand() {
        System.out.println("Відбувається додання власного депозиту");
    }
}
