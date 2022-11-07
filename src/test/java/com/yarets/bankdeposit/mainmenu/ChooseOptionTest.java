package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.CurrencyEnum;
import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChooseOptionTest {
    @Mock
    MainMenuCommand mainMenuCommand = new ChooseOption();
    @Mock
    DefaultDeposit defaultDeposit = new DefaultDeposit();
    @Test
    void doCommand() {
    }

    @Test
    void setDeposit() {
    }

    @Test
    void chooseMoneyDeposit() {
        try{
            Method method = ChooseOption.class.getDeclaredMethod("chooseMoneyDeposit", DefaultDeposit.class);
            method.setAccessible(true);
            String data = "123";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            assertEquals(123, method.invoke(mainMenuCommand, defaultDeposit));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void chooseTermDeposit() {
        try{
            Method method = ChooseOption.class.getDeclaredMethod("chooseTermDeposit", null);
            method.setAccessible(true);
            String data = "13";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            assertEquals(13, method.invoke(mainMenuCommand));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void chooseCap() {
        try{
            Method method = ChooseOption.class.getDeclaredMethod("chooseCap", null);
            method.setAccessible(true);
            String data = "1";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            assertEquals(1, method.invoke(mainMenuCommand));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void chooseCurrency() {
        try{
            Method method = ChooseOption.class.getDeclaredMethod("chooseCurrency", null);
            method.setAccessible(true);
            String data = "UAH";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            assertEquals(CurrencyEnum.UAH, method.invoke(mainMenuCommand));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void createSomeDeposit() {
    }
}