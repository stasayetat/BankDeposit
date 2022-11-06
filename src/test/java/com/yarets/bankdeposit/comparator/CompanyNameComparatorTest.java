package com.yarets.bankdeposit.comparator;

import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyNameComparatorTest {

    @Test
    void testCompare() {
        DefaultDeposit defaultDeposit1  = DefaultDeposit.builder().setCompanyName("bCompanyName").build();
        DefaultDeposit defaultDeposit2  = DefaultDeposit.builder().setCompanyName("aCompanyName").build();
        CompanyNameComparator companyNameComparator = new CompanyNameComparator();
        assertEquals(1, companyNameComparator.compare(defaultDeposit1,defaultDeposit2));
    }
}