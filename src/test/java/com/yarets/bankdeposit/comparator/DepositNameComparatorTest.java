package com.yarets.bankdeposit.comparator;

import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositNameComparatorTest {
    @Test
    void testCompare() {
        DefaultDeposit defaultDeposit1  = DefaultDeposit.builder().setDepositName("aDepositName").build();
        DefaultDeposit defaultDeposit2  = DefaultDeposit.builder().setDepositName("bDepositName").build();
        DepositNameComparator depositNameComparator = new DepositNameComparator();
        assertEquals(-1, depositNameComparator.compare(defaultDeposit1, defaultDeposit2));
    }
}