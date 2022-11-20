package com.yarets.bankdeposit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.yarets.bankdeposit.CurrencyEnum.UAH;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DataInputTest {
    private final static InputStream systemIn = System.in;
    private final static PrintStream systemOut = System.out;
    private ByteArrayInputStream typeIn;
    private static ByteArrayOutputStream typeOut;
    @Mock
    DataInput dpi = new DataInput();
    @AfterEach
    void tearDown() {
        System.setIn(systemIn);
    }
//    @Test
//    void testInputIntRight() throws Exception {
//        String data = "123";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        assertEquals(123, dpi.inputInt());
//    }
//
//    @Test
//    void testInputIntWrong() throws Exception {
//        String data = "qwe";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        assertThrows(Exception.class, () -> dpi.inputInt());
//    }
//
//    @Test
//    void testInputOneZeroRight() throws Exception {
//        String data = "0";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        assertEquals(0, dpi.inputOneZero());
//    }
//
//    @Test
//    void testInputOneZeroWrong() {
//        String data = "3";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        assertThrows(Exception.class, () -> dpi.inputOneZero());
//    }
//
//    @Test
//    void inputMoreRight() {
//        String data = "80";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        assertEquals(80, dpi.inputMore(100));
//    }
//
//    @Test
//    void inputMoreWrong() {
//        String data = "120";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        assertThrows(Exception.class, () -> dpi.inputMore(100));
//    }
//
//    @Test
//    void inputLessRight() {
//        String data = "123";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        assertEquals(123, dpi.inputLess(100));
//    }
//
//    @Test
//    void inputLessWrong() {
//        String data = "45";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        assertThrows(Exception.class, () -> dpi.inputLess(100));
//    }
//
//    @Test
//    void inputDoubleRight() {
//        String data = "123,0";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        assertEquals(123.0, dpi.inputDouble());
//    }
//
//    @Test
//    void inputDoubleWrong() {
//        String data = "45.0";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        assertThrows(Exception.class, () -> dpi.inputDouble());
//    }

    @Test
    void testInputCurrency() {
        String data = "UAH";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        assertEquals(UAH, dpi.inputCurrency());
    }

}