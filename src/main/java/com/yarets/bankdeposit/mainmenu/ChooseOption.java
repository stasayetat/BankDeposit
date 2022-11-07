package com.yarets.bankdeposit.mainmenu;


import com.yarets.bankdeposit.CurrencyEnum;
import com.yarets.bankdeposit.DataInput;
import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.util.ArrayList;
import java.util.List;

public class ChooseOption implements MainMenuCommand {
    protected List<DefaultDeposit> patternDeposit = new ArrayList<>();
    protected DataInput dpi = new DataInput();
    public ChooseOption() {
        createSomeDeposit(patternDeposit);
    }

    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        DefaultDeposit curDeposit = new DefaultDeposit();
        DataInput dpi = new DataInput();
        System.out.println("Виберіть один з наявних депозитів: ");
        for(int i = 0; i < patternDeposit.size(); i++){
            System.out.println(i+1 + ":" + patternDeposit.get(i));
        }
        int indDep = dpi.inputMore(patternDeposit.size());
        curDeposit = patternDeposit.get(indDep-1);
        setDeposit(curDeposit);
        listDeposit.add(curDeposit);
        curDeposit.calcInvest();
    }

    protected void setDeposit(DefaultDeposit curDeposit){
        DataInput dpi = new DataInput();
        int maxMoney = chooseMoneyDeposit(curDeposit);
        curDeposit.setAmountMoney(maxMoney);
        int maxMonth = chooseTermDeposit();
        curDeposit.setTermOfDeposit(maxMonth);
        int[] earlyTerm = chooseEarlyTerm(maxMonth,maxMoney);
        curDeposit.setEarlyTerm(earlyTerm[0]);
        curDeposit.setMayEarnMoney((double) earlyTerm[1]);
        curDeposit.setMonthlyCapitalization(chooseCap());
        curDeposit.setAmountMonthlyAdd(chooseMonthlyAdd());
        curDeposit.setCurrency(chooseCurrency());
    }

    protected int chooseMoneyDeposit(DefaultDeposit defaultDeposit){
        System.out.println("Введіть кількість грошей, які плануєте покласти на депозит:");
        return dpi.inputLess(defaultDeposit.getMinInvestMoney());
    }



    protected int chooseTermDeposit(){
        System.out.println("Введіть кількість часу для депозиту(у місяцях):");
        return dpi.inputInt();
    }

    protected int[] chooseEarlyTerm(int tmpMounth, int tmpAmount){
        System.out.println("Введіть чи плануєте ви забирати кошти до вказаного часу?(Так - 1, Ні - 0)");
        int tmpValue = dpi.inputOneZero();
        int[] wishRes = new int[2];
        wishRes[0] = 0;
        wishRes[1] = 0;
        if(tmpValue == 1){
            System.out.println("Введіть, коли ви плануєте забрати гроші:(не більше) " + tmpMounth);
            int tmpEarlyMounth = dpi.inputMore(tmpMounth);
            wishRes[0] = tmpEarlyMounth;
            System.out.println("Введіть, скільки ви плануєте забрати:(не більше) " + tmpAmount);
            int tmpEarlyAmount  = dpi.inputMore(tmpAmount);
            wishRes[1] = tmpEarlyAmount;
        }
            return wishRes;
    }

    protected int chooseCap(){
        System.out.println("Введіть чи плануєте ви щомісячну капіталізацію?(Так - 1, Ні - 0)");
        return dpi.inputOneZero();
    }

    protected int chooseMonthlyAdd(){
        System.out.println("Введіть чи плануєте ви додавати гроші щомісячно?(Так - 1, Ні - 0)");
        int tmpValue = dpi.inputOneZero();
        if(tmpValue == 1){
            System.out.println("Введіть скільки ви плануєте додати:");
            tmpValue = dpi.inputInt();
        }
        return tmpValue;
    }
    protected CurrencyEnum chooseCurrency(){
        System.out.println("Виберіть валюту для депозиту, якщо вибрано не UAH то відсоток у 10 раз менше:");
        return dpi.inputCurrency();
    }

    protected void createSomeDeposit(List<DefaultDeposit> patternDeposit) {
        DefaultDeposit defDeposit = DefaultDeposit.builder()
                .setDepositName("ForYoungPeople")
                .setCompanyName("Alfa-bank")
                .setPercentage(6.5)
                .build();
        patternDeposit.add(defDeposit);
        defDeposit = DefaultDeposit.builder()
                .setDepositName("Big Bank")
                .setCompanyName("PrivatBank")
                .setPercentage(14.0)
                .setMinInvestMoney(10000)
                .build();
        patternDeposit.add(defDeposit);
        defDeposit = DefaultDeposit.builder()
                .setDepositName("Fast Money")
                .setCompanyName("Pumb")
                .setPercentage(9.0)
                .setMinInvestMoney(10)
                .build();
        patternDeposit.add(defDeposit);
    }

}
