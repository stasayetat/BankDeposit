package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;

import java.util.List;

public interface MainMenuCommand {
    void doCommand(List<DefaultDeposit> listDeposit);
}
