
package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.CurrencyEnum;
import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CurrentOptionTest {

    private final List<DefaultDeposit> deposits = new ArrayList<>();

    @Test
    void testDoCommand() {
        DefaultDeposit defaultDeposit1 = DefaultDeposit.builder()
                .setDepositName("TestDeposit1")
                .setCompanyName("TestCompany1")
                .setPercentage(10.0)
                .build();
        defaultDeposit1.setAmountMoney(100);
        defaultDeposit1.setCurrency(CurrencyEnum.USD);
        defaultDeposit1.setTermOfDeposit(12);
        defaultDeposit1.calcInvest();
        deposits.add(defaultDeposit1);
        String consoleOutPut = null;
        PrintStream originalOut = System.out;
        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1000);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            MainMenuCommand mainMenuCommand = new CurrentOption();
            mainMenuCommand.doCommand(deposits);
            capture.flush();
            consoleOutPut = outputStream.toString();
            System.setOut(originalOut);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals("Всі підключені депозити:\r\n" +
                "1:Компанія:TestCompany1" + ", ім'я депозиту: TestDeposit1" +  ", відсоток: 10.0" + ", можливість раннього зняття коштів: не можливо"
                + "\r\nмінімальна кількість грошей: 0" + ", вкладених грошей: 100" + "\r\nкількість часу: 12"
                + ", капіталізація: не можливо"
                + ", валюта: USD" + ", можливо зароблені гроші: 101.01917808219179\r\n",

                "Всі підключені депозити:\r\n" +
                "1:Компанія:TestCompany1, ім'я депозиту: TestDeposit1, відсоток: 10.0, можливість раннього зняття коштів: не можливо\r\n" +
                "мінімальна кількість грошей: 0, вкладених грошей: 100\r\n" +
                "кількість часу: 12, капіталізація: не можливо, валюта: USD, можливо зароблені гроші: 101.01917808219179\r\n");
    }
}