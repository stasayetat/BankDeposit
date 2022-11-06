package com.yarets.bankdeposit.comparator;

import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmountMoneyComparatorTest {

    @Test
    void testCompare() {
        DefaultDeposit defaultDeposit1  = new DefaultDeposit();
        defaultDeposit1.setAmountMoney(1000);
        DefaultDeposit defaultDeposit2  = new DefaultDeposit();
        defaultDeposit2.setAmountMoney(2000);
        AmountMoneyComparator amountMoneyComparator = new AmountMoneyComparator();
        assertEquals(-1000, amountMoneyComparator.compare(defaultDeposit1, defaultDeposit2));
    }
}