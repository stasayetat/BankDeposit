package com.yarets.bankdeposit.deposit;

import com.yarets.bankdeposit.CurrencyEnum;
import com.yarets.bankdeposit.mainmenu.MainMenuCommand;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultDepositTest {


    @Mock
    private MainMenuCommand mainMenuCommand;

    @Mock
    private DefaultDeposit defaultDepositSet;
    @BeforeEach
    public void setup() {
        defaultDepositSet = DefaultDeposit.builder()
                .setCompanyName("TestCompany1")
                .setDepositName("TestDeposit1")
                .setPercentage(10.0)
                .setMinInvestMoney(4321)
                .build();
        defaultDepositSet.setAmountMoney(1000);
        defaultDepositSet.setTermOfDeposit(12);
        defaultDepositSet.setEarlyTerm(3);
        defaultDepositSet.setEarlyAmount(100.0);
        defaultDepositSet.setMonthlyCapitalization(1);
        defaultDepositSet.setAmountMonthlyAdd(250);
        defaultDepositSet.setCurrency(CurrencyEnum.USD);
    }

    @Test
    public void testGetterDeposit() {
        assertEquals("TestCompany1", defaultDepositSet.getCompanyName());
        assertEquals("TestDeposit1", defaultDepositSet.getDepositName());
        assertEquals(10.0, defaultDepositSet.getPercentage());
        assertEquals(1000, defaultDepositSet.getAmountMoney());
        assertEquals(4321, defaultDepositSet.getMinInvestMoney());
    }

    @Test
    void testCalcInvest() {
        assertEquals(3673.4404036314836, defaultDepositSet.calcInvest());

    }

    @Test
    void testToString() {
        assertEquals("Компанія:TestCompany1" + ", ім'я депозиту: TestDeposit1" +
                ", відсоток: " + 10.0 + ", можливість раннього зняття коштів: " +
                "не можливо" + ", мінімальна кількість грошей: " + 4321, defaultDepositSet.toString());
    }

    @Test
    void testPrintString() {
        defaultDepositSet.calcInvest();
        assertEquals("Компанія:" + "TestCompany1" + ", ім'я депозиту: " + "TestDeposit1" + ", відсоток: " + 10.0 + ", можливість раннього зняття коштів: "
                + "можливо" + "\nмінімальна кількість грошей: " + 4321 + ", вкладених грошей: " + 1000 + "\nкількість часу: "
                + 12 + ", капіталізація: " + "можливо"
                + ", валюта: " + CurrencyEnum.USD + ", можливо зароблені гроші: " + 3673.4404036314836, defaultDepositSet.printString());
    }

}