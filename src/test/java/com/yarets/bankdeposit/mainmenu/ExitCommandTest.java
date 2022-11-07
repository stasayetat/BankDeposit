package com.yarets.bankdeposit.mainmenu;

import com.github.stefanbirkner.systemlambda.SystemLambda;
import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExitCommandTest {
    private List<DefaultDeposit> actualDeposit = new ArrayList<>();
    private MainMenuCommand mainMenuCommand = new ExitCommand();


    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
    @Test
    void testDoCommand() {
        //exit.expectSystemExitWithStatus(0);
        //mainMenuCommand.doCommand(actualDeposit);
    }
}