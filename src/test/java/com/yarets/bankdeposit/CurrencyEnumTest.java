package com.yarets.bankdeposit;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyEnumTest {

    @Test
    void testValueUAH() {
        CurrencyEnum testCurrency = CurrencyEnum.UAH;
        assertEquals(CurrencyEnum.UAH, testCurrency);
    }
}