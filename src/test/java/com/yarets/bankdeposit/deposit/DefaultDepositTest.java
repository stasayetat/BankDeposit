package com.yarets.bankdeposit.deposit;

import com.yarets.bankdeposit.CurrencyEnum;
import com.yarets.bankdeposit.mainmenu.MainMenuCommand;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultDepositTest {


    @Mock
    private MainMenuCommand mainMenuCommand;

    @Mock
    private DefaultDeposit defaultDepositSet = new DefaultDeposit();
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCompanyName() {
        DefaultDeposit defaultDeposit = DefaultDeposit.builder()
                .setCompanyName("TestCompany1")
                .build();
        assertEquals("TestCompany1", defaultDeposit.getCompanyName());
    }

    @Test
    void testGetDepositName() {
        DefaultDeposit defaultDeposit = DefaultDeposit.builder()
                .setDepositName("TestDeposit1")
                .build();
        assertEquals("TestDeposit1", defaultDeposit.getDepositName());
    }

    @Test
    void testGetPercentage() {
        DefaultDeposit defaultDeposit = DefaultDeposit.builder()
                .setPercentage(20.0)
                .build();
        assertEquals(20.0, defaultDeposit.getPercentage());
    }

    @Test
    void testGetAmountMoney() {
        DefaultDeposit defaultDeposit = new DefaultDeposit();
        defaultDeposit.setAmountMoney(1234);
        assertEquals(1234, defaultDeposit.getAmountMoney());
    }

    @Test
    void testGetMinInvestMoney() {
        DefaultDeposit defaultDeposit = DefaultDeposit.builder()
                .setMinInvestMoney(4321)
                .build();
        assertEquals(4321, defaultDeposit.getMinInvestMoney());
    }

    @Test
    void testSetAmountMoney() {
        defaultDepositSet.setAmountMoney(1234);
        assertEquals(1234, defaultDepositSet.getAmountMoney());
    }


    @Test
    void testCalcInvest() {
        DefaultDeposit defaultDepositInvest = DefaultDeposit.builder()
                                            .setDepositName("TestDeposit")
                                            .setCompanyName("TestCompany")
                                            .setPercentage(10.0)
                                            .build();
        defaultDepositInvest.setAmountMoney(1000);
        defaultDepositInvest.setTermOfDeposit(12);
        defaultDepositInvest.setEarlyTerm(3);
        defaultDepositInvest.setEarlyAmount(100.0);
        defaultDepositInvest.setMonthlyCapitalization(1);
        defaultDepositInvest.setAmountMonthlyAdd(250);
        defaultDepositInvest.setCurrency(CurrencyEnum.USD);
        assertEquals(3673.4404036314836, defaultDepositInvest.calcInvest());

    }

    @Test
    void testToString() {
        DefaultDeposit defaultDepositToString = DefaultDeposit.builder()
                .setCompanyName("TestCompanyToString")
                .setDepositName("TestDepositToString")
                .setPercentage(123.0)
                .setMinInvestMoney(100)
                .build();
        assertEquals("Компанія:TestCompanyToString" + ", ім'я депозиту: TestDepositToString" +
                ", відсоток: " + 123.0 + ", можливість раннього зняття коштів: " +
                "не можливо" + ", мінімальна кількість грошей: " + 100, defaultDepositToString.toString());
    }

    @Test
    void testPrintString() {
        DefaultDeposit defaultDepositPrintString = DefaultDeposit.builder()
                .setDepositName("TestDeposit")
                .setCompanyName("TestCompany")
                .setPercentage(10.0)
                .setMinInvestMoney(123)
                .build();
        defaultDepositPrintString.setAmountMoney(1000);
        defaultDepositPrintString.setTermOfDeposit(12);
        defaultDepositPrintString.setEarlyTerm(3);
        defaultDepositPrintString.setEarlyAmount(100.0);
        defaultDepositPrintString.setMonthlyCapitalization(1);
        defaultDepositPrintString.setAmountMonthlyAdd(250);
        defaultDepositPrintString.setCurrency(CurrencyEnum.USD);
        defaultDepositPrintString.calcInvest();
        assertEquals("Компанія:" + "TestCompany" + ", ім'я депозиту: " + "TestDeposit" + ", відсоток: " + 10.0 + ", можливість раннього зняття коштів: "
                + "можливо" + "\nмінімальна кількість грошей: " + 123 + ", вкладених грошей: " + 1000 + "\nкількість часу: "
                + 12 + ", капіталізація: " + "можливо"
                + ", валюта: " + CurrencyEnum.USD + ", можливо зароблені гроші: " + 3673.4404036314836, defaultDepositPrintString.printString());
    }
}