package com.yarets.bankdeposit.Deposits;

import com.yarets.bankdeposit.ListOfCurrency;

import java.util.*;

public class DefaultDeposit {
    private String companyName;
    private String depositName;
    private Boolean earlyTerm;
    private Double percentage;
    private Integer minInvestMoney = 0;
    private Integer amountMoney;
    private Integer termOfDeposit;
    private Integer amountMonthlyAdd = 0;
    private Double mayEarnMoney;
    private ListOfCurrency currency;
    private Map<Integer, Double> earnMonthly = new LinkedHashMap<>();
    public DefaultDeposit() {

    }

    public DefaultDeposit(String companyName, String depositName, Boolean earlyTerm, Double percentage, Integer minInvestMoney) {
        this.companyName = companyName;
        this.depositName = depositName;
        this.earlyTerm = earlyTerm;
        this.percentage = percentage;
        this.minInvestMoney = minInvestMoney;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDepositName() {
        return depositName;
    }

    public Boolean getEarlyTerm() {
        return earlyTerm;
    }

    public Double getPercentage() {
        return percentage;
    }

    public Integer getMinInvestMoney() {
        return minInvestMoney;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAmountMoney(Integer amountMoney) {
        this.amountMoney = amountMoney;
    }

    public void setTermOfDeposit(Integer termOfDeposit) {
        this.termOfDeposit = termOfDeposit;
    }

    public void setAmountMonthlyAdd(Integer amountMonthlyAdd) {
        this.amountMonthlyAdd = amountMonthlyAdd;
    }

    public void setCurrency(ListOfCurrency currency) {
        this.currency = currency;
    }

    public static DepositBuilder builder() {
        return new DepositBuilder();
    }

    public static class DepositBuilder {

        private DefaultDeposit deposit;

        DepositBuilder() {
            this.deposit = new DefaultDeposit();
        }

        public DepositBuilder setCompanyName(String companyName) {
            deposit.companyName = companyName;
            return this;
        }

        public DepositBuilder setDepositName(String depositName) {
            deposit.depositName = depositName;
            return this;
        }

        public DepositBuilder setEarlyTerm(Boolean earlyTerm) {
            deposit.earlyTerm = earlyTerm;
            return this;
        }


        public DepositBuilder setPercentage(Double percentage) {
            deposit.percentage = percentage;
            return this;
        }

        public DepositBuilder setMinInvestMoney(Integer minInvestMoney) {
            deposit.minInvestMoney = minInvestMoney;
            return this;
        }

        public DefaultDeposit build() {
            return deposit;
        }
    }

    public void calcInvest() {
        int chMonth = 1;
        double sumEarn = 0;
        double tmpAmount = amountMoney;
        double earnMoney = 0;
        if (currency != ListOfCurrency.UAH)
            percentage /= 10;
        while(chMonth  <= termOfDeposit){
            earnMoney = (((double)tmpAmount/100)*(percentage/365)*31);
            earnMonthly.put(chMonth, earnMoney);
            tmpAmount += amountMonthlyAdd;
            sumEarn += earnMoney;
            chMonth++;
        }
        sumEarn += tmpAmount;
        sumEarn -= amountMonthlyAdd;
        printInvest(currency);
        System.out.println("Загалом зароблено " + sumEarn);
        mayEarnMoney = sumEarn;
    }

    @Override
    public String toString() {
        String earlyTermStr;
        if(earlyTerm)
            earlyTermStr = "можливо";
        else
            earlyTermStr = "не можливо";
        return "Компанія:" + companyName + ", ім'я депозиту: " + depositName + ", відсоток: " + percentage + ", можливість раннього зняття коштів: " + earlyTermStr + ", мінімальна кількість грошей: " + minInvestMoney;
    }

    public String printString() {
        String earlyTermStr;
        if(earlyTerm)
            earlyTermStr = "можливо";
        else
            earlyTermStr = "не можливо";
        return "Компанія:" + companyName + ", ім'я депозиту: " + depositName + ", відсоток: " + percentage + ", можливість раннього зняття коштів: "
                + earlyTermStr + ", мінімальна кількість грошей: " + minInvestMoney + ", вкладених грошей: " + amountMoney + "\nкількість часу: "
                + termOfDeposit + ", валюта: " + currency + ", можливо зароблені гроші: " + mayEarnMoney;
    }
    private void printInvest(ListOfCurrency currency){
        for(Map.Entry mp : earnMonthly.entrySet()){
            System.out.println("За " + mp.getKey() + " місяць зароблено " + mp.getValue() + currency);
        }


    }
}
