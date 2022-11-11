package com.yarets.bankdeposit.deposit;
import com.yarets.bankdeposit.CurrencyEnum;

import java.util.*;

public class DefaultDeposit {
    private String companyName;
    private String depositName;
    private Integer earlyTerm = 0;

    private Double earlyAmount = 0.0;
    private Double percentage;
    private Integer minInvestMoney = 0;
    private Integer amountMoney;
    private Integer termOfDeposit;
    private Integer amountMonthlyAdd = 0;
    private Integer monthlyCapitalization = 0;
    private Double mayEarnMoney;
    private CurrencyEnum currency;
    private Map<Integer, Double> earnMonthly = new LinkedHashMap<>();
    public DefaultDeposit() {

    }

    public DefaultDeposit(String companyName, String depositName, Integer earlyTerm, Double percentage, Integer minInvestMoney) {
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

    public Double getPercentage() {
        return percentage;
    }

    public Integer getAmountMoney() {
        return amountMoney;
    }

    public Integer getMinInvestMoney() {
        return minInvestMoney;
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

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public void setEarlyAmount(Double earlyAmount) {
        this.earlyAmount = earlyAmount;
    }

    public void setEarlyTerm(Integer earlyTerm) {
        this.earlyTerm = earlyTerm;
    }

    public void setMonthlyCapitalization(Integer monthlyCapitalization) {
        this.monthlyCapitalization = monthlyCapitalization;
    }

    public void setMayEarnMoney(Double mayEarnMoney) {
        this.mayEarnMoney = mayEarnMoney;
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

    public double calcInvest() {
        int chMonth = 1;
        double sumEarn = 0;
        double tmpAmount = this.amountMoney;
        double earnMoney = 0;
        double tmpPercent = this.percentage;
        if (this.currency != CurrencyEnum.UAH)
            tmpPercent /= 10;

        while(chMonth  <= this.termOfDeposit){
            if(chMonth == this.earlyTerm)
                tmpAmount -= this.earlyAmount;
            earnMoney = (((double)tmpAmount/100)*(tmpPercent/365)*31);
            this.earnMonthly.put(chMonth, earnMoney);
            tmpAmount += this.amountMonthlyAdd;
            if(this.monthlyCapitalization == 1)
                tmpAmount += earnMoney;
            sumEarn += earnMoney;
            chMonth++;
        }
        tmpAmount -= this.amountMonthlyAdd;
        if(this.monthlyCapitalization == 0)
            sumEarn += tmpAmount;
        else{
            sumEarn = tmpAmount;
        }
        printInvest(this.currency);
        System.out.println("Загалом зароблено " + sumEarn);
        this.mayEarnMoney = sumEarn;
        return sumEarn;
    }

    @Override
    public String toString() {
        String earlyTermStr;
        if(earlyTerm == 1)
            earlyTermStr = "можливо";
        else
            earlyTermStr = "не можливо";
        return "Компанія:" + companyName + ", ім'я депозиту: " + depositName +
                ", відсоток: " + percentage + ", можливість раннього зняття коштів: " +
                earlyTermStr + ", мінімальна кількість грошей: " + minInvestMoney;
    }

    public String printString() {
        String earlyTermStr;
        String capStr;
        if(earlyTerm != 0)
            earlyTermStr = "можливо";
        else
            earlyTermStr = "не можливо";
        if(monthlyCapitalization == 1)
            capStr = "можливо";
        else
            capStr = "не можливо";
        return "Компанія:" + companyName + ", ім'я депозиту: " + depositName + ", відсоток: " + percentage + ", можливість раннього зняття коштів: "
                + earlyTermStr + "\nмінімальна кількість грошей: " + minInvestMoney + ", вкладених грошей: " + amountMoney + "\nкількість часу: "
                + termOfDeposit + ", капіталізація: " + capStr
                + ", валюта: " + currency + ", можливо зароблені гроші: " + mayEarnMoney;
    }
    private void printInvest(CurrencyEnum currency){
        for(Map.Entry mp : earnMonthly.entrySet()){
            System.out.println("За " + mp.getKey() + " місяць зароблено " + mp.getValue() + " " + currency);
        }


    }
}