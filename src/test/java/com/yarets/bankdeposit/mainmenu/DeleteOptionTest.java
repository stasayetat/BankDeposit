package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeleteOptionTest {
    @Mock
    private List<DefaultDeposit> testListDeposit = new ArrayList<>();
    @Mock
    MainMenuCommand mainMenuCommand = new DeleteOption();
    @Test
    void testDoCommand() {
        DefaultDeposit defDeposit = DefaultDeposit.builder()
                .setDepositName("ForYoungPeople")
                .setCompanyName("Alfa-bank")
                .setPercentage(6.5)
                .build();
        testListDeposit.add(defDeposit);
        defDeposit = DefaultDeposit.builder()
                .setDepositName("Big Bank")
                .setCompanyName("PrivatBank")
                .setPercentage(14.0)
                .setMinInvestMoney(10000)
                .build();
        testListDeposit.add(defDeposit);
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenuCommand.doCommand(testListDeposit);
        assertEquals("PrivatBank", testListDeposit.get(0).getCompanyName());
    }
}