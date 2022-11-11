package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.util.List;

public class PrintOption implements MainMenuCommand {
    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        System.out.println("Всі підключені депозити:");
        for(int i = 0; i < listDeposit.size(); i++){
            System.out.println(i+1 + ":" + listDeposit.get(i).printString());
        }
    }
}

