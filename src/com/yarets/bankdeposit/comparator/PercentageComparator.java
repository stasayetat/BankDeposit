package com.yarets.bankdeposit.comparator;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;

import java.util.Comparator;

public class PercentageComparator implements Comparator<DefaultDeposit> {
@Override
public int compare(DefaultDeposit dep1, DefaultDeposit dep2) {
    return dep1.getPercentage().compareTo(dep2.getPercentage());

}
}