package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchOptionTest {
    @Mock
    private List<DefaultDeposit> testListDeposit = new ArrayList<>();
    @Mock
    private List<DefaultDeposit> testSearchListDeposit = new ArrayList<>();
    @Mock
    MainMenuCommand mainMenuCommand = new SearchOption();

    @Mock
    List<String> verA = new ArrayList<>();

    @Test
    void doCommand() {
    }

    @Before
    void setUp(){
        DefaultDeposit defDeposit = DefaultDeposit.builder()
                .setDepositName("ForYoungPeople")
                .setCompanyName("Alfa-bank")
                .setPercentage(6.5)
                .build();
        testListDeposit.add(defDeposit);
        testSearchListDeposit.add(defDeposit);
        defDeposit = DefaultDeposit.builder()
                .setDepositName("Big Bank")
                .setCompanyName("PrivatBank")
                .setPercentage(14.0)
                .setMinInvestMoney(10000)
                .build();
        testListDeposit.add(defDeposit);
    }
    @Test
    void testSearchDepositCompanyName(){
        try{
            Method method = SearchOption.class.getDeclaredMethod("searchDeposit", Integer.class, List.class);
            method.setAccessible(true);
            String data = "Alfa";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            assertEquals(testSearchListDeposit, method.invoke(mainMenuCommand, 1, testListDeposit));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSearchDepositDepositName(){
        try{
            Method method = SearchOption.class.getDeclaredMethod("searchDeposit", Integer.class, List.class);
            method.setAccessible(true);
            String data = "For";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            assertEquals(testSearchListDeposit, method.invoke(mainMenuCommand, 2, testListDeposit));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSearchDepositPercentage(){
        try{
            Method method = SearchOption.class.getDeclaredMethod("searchDeposit", Integer.class, List.class);
            method.setAccessible(true);
            String data = "6,5";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            assertEquals(testSearchListDeposit, method.invoke(mainMenuCommand, 3, testListDeposit));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCreateArr() {

        try {
            Method method = SearchOption.class.getDeclaredMethod("createArr", null);
            method.setAccessible(true);
            verA = (List<String>) method.invoke(mainMenuCommand);
            assertEquals(4, verA.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testChoosePattern() {
        try {
            Method method = SearchOption.class.getDeclaredMethod("choosePattern", List.class);
            method.setAccessible(true);
            String data = "2";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            verA.add("1. Назва компанії");
            verA.add("2. Назва депозиту");
            verA.add("3. Кількість відсотків");
            verA.add("4. Кількість грошей");
            int qwe = (int) method.invoke(mainMenuCommand, verA);
            assertEquals(2, qwe);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}