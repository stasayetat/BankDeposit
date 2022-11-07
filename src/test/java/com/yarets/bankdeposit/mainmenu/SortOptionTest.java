package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortOptionTest {
    @Mock
    private List<DefaultDeposit> testListDeposit = new ArrayList<>();
    @Mock
    MainMenuCommand mainMenuCommand = new SortOption();
    @BeforeEach
    void setUp() {
        testListDeposit.clear();
        DefaultDeposit defDeposit = DefaultDeposit.builder()
                .setDepositName("ForYoungPeople")
                .setCompanyName("Alfa-bank")
                .setPercentage(6.5)
                .build();
        defDeposit.setAmountMoney(10);
        testListDeposit.add(defDeposit);
        defDeposit = DefaultDeposit.builder()
                .setDepositName("Big Bank")
                .setCompanyName("PrivatBank")
                .setPercentage(14.0)
                .setMinInvestMoney(10000)
                .build();
        defDeposit.setAmountMoney(20);
        testListDeposit.add(defDeposit);
    }
    @Test
    void testSortDepositCompanyName() {
        try{
            Method method = SortOption.class.getDeclaredMethod("sortDeposit", Integer.class, List.class);
            method.setAccessible(true);
            String data = "0";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            String wishRes = testListDeposit.get(1).getCompanyName();
            method.invoke(mainMenuCommand, 1, testListDeposit);
            assertEquals(testListDeposit.get(1).getCompanyName(), wishRes);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSortDepositDepositName() {
        try{
            Method method = SortOption.class.getDeclaredMethod("sortDeposit", Integer.class, List.class);
            method.setAccessible(true);
            String data = "1";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            String wishRes = testListDeposit.get(0).getDepositName();
            method.invoke(mainMenuCommand, 2, testListDeposit);
            assertEquals(testListDeposit.get(0).getDepositName(), wishRes);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSortDepositPercentage() {
        try{
            Method method = SortOption.class.getDeclaredMethod("sortDeposit", Integer.class, List.class);
            method.setAccessible(true);
            String data = "0";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Double wishRes = testListDeposit.get(1).getPercentage();
            method.invoke(mainMenuCommand, 3, testListDeposit);
            assertEquals(testListDeposit.get(1).getPercentage(), wishRes);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSortDepositAmountMoney() {
        try{
            Method method = SortOption.class.getDeclaredMethod("sortDeposit", Integer.class, List.class);
            method.setAccessible(true);
            String data = "1";
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Integer wishRes = testListDeposit.get(1).getAmountMoney();
            method.invoke(mainMenuCommand, 4, testListDeposit);
            assertEquals(testListDeposit.get(0).getAmountMoney(), wishRes);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}