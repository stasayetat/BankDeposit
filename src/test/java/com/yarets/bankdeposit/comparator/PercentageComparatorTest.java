package com.yarets.bankdeposit.comparator;

import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercentageComparatorTest {

    @Test
    void testCompare() {
        DefaultDeposit defaultDeposit1  = DefaultDeposit.builder().setPercentage(12.0).build();
        DefaultDeposit defaultDeposit2  = DefaultDeposit.builder().setPercentage(24.0).build();
        PercentageComparator percentageComparator = new PercentageComparator();
        assertEquals(-1, percentageComparator.compare(defaultDeposit1, defaultDeposit2));
    }
}