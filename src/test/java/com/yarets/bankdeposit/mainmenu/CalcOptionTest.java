package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.CurrencyEnum;
import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalcOptionTest {
    @Mock
    MainMenuCommand mainMenuCommand = new CalcOption();
    @Mock
    private List<DefaultDeposit> testListDeposit = new ArrayList<>();
    @Test
    void testDoCommand() {
        DefaultDeposit defDeposit = DefaultDeposit.builder()
                .setDepositName("ForYoungPeople")
                .setCompanyName("Alfa-bank")
                .setPercentage(6.5)
                .build();
        defDeposit.setAmountMoney(100);
        defDeposit.setTermOfDeposit(12);
        defDeposit.setCurrency(CurrencyEnum.UAH);
        testListDeposit.add(defDeposit);
        String consoleOutPut = null;
        PrintStream originalOut = System.out;
        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1000);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            String data = "1";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            mainMenuCommand.doCommand(testListDeposit);
            capture.flush();
            consoleOutPut = outputStream.toString();
            System.setOut(originalOut);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals("Виберіть депозит, який хочете порахувати:\r\n" +
                "1:Компанія:Alfa-bank, ім'я депозиту: ForYoungPeople, відсоток: 6.5, можливість раннього зняття коштів: не можливо, мінімальна кількість грошей: 0\r\n" +
                "Введіть: \r\n" +  "За 1 місяць зароблено 0.552054794520548 UAH\r\n" +
                "За 2 місяць зароблено 0.552054794520548 UAH\r\n" +
                "За 3 місяць зароблено 0.552054794520548 UAH\r\n" +
                "За 4 місяць зароблено 0.552054794520548 UAH\r\n" +
                "За 5 місяць зароблено 0.552054794520548 UAH\r\n" +
                "За 6 місяць зароблено 0.552054794520548 UAH\r\n" +
                "За 7 місяць зароблено 0.552054794520548 UAH\r\n" +
                "За 8 місяць зароблено 0.552054794520548 UAH\r\n" +
                "За 9 місяць зароблено 0.552054794520548 UAH\r\n" +
                "За 10 місяць зароблено 0.552054794520548 UAH\r\n" +
                "За 11 місяць зароблено 0.552054794520548 UAH\r\n" +
                "За 12 місяць зароблено 0.552054794520548 UAH\r\n" +
                "Загалом зароблено 106.62465753424658\r\n", consoleOutPut);
    }
}