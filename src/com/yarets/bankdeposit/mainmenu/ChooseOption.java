package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.DataInput;
import com.yarets.bankdeposit.Deposits.DefaultDeposit;
import com.yarets.bankdeposit.CurrencyEnum;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ChooseOption implements MainMenuCommand {
    protected List<DefaultDeposit> patternDeposit = new ArrayList<>();
    public ChooseOption() {
        createSomeDeposit();
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

        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть кількість грошей, які плануєте покласти на депозит:");
        int tmpAmount = dpi.inputLess(curDeposit.getMinInvestMoney());
        curDeposit.setAmountMoney(tmpAmount);

        System.out.println("Введіть кількість часу для депозиту(у місяцях):");
        int tmpMount = dpi.inputInt();
        curDeposit.setTermOfDeposit(tmpMount);

        System.out.println("Введіть чи плануєте ви забирати кошти до вказаного часу?(Так - 1, Ні - 0)");
        int tmpValue = dpi.inputOneZero();
        if(tmpValue == 1){
            System.out.println("Введіть, коли ви плануєте забрати гроші:(не більше) " + tmpMount);
            int tmpEarlyMounth = dpi.inputMore(tmpMount);
            curDeposit.setEarlyTerm(tmpEarlyMounth);
            System.out.println("Введіть, скільки ви плануєте забрати:(не більше) " + tmpAmount);
            int tmpEarlyAmount  = dpi.inputMore(tmpAmount);
            curDeposit.setEarlyAmount((double) tmpEarlyAmount);
        }

        System.out.println("Введіть чи плануєте ви щомісячну капіталізацію?(Так - 1, Ні - 0)");
        tmpValue = dpi.inputOneZero();
        curDeposit.setMonthlyCapitalization(tmpValue);

        System.out.println("Введіть чи плануєте ви додавати гроші щомісячно?(Так - 1, Ні - 0)");
        tmpValue = dpi.inputOneZero();
        if(tmpValue == 1){
            System.out.println("Введіть скільки ви плануєте додати:");
            tmpValue = dpi.inputInt();
            curDeposit.setAmountMonthlyAdd(tmpValue);
        }

        System.out.println("Виберіть валюту для депозиту, якщо вибрано не UAH то відсоток у 10 раз менше:");
        CurrencyEnum curCurrency = CurrencyEnum.UAH;

        curCurrency = dpi.inputCurrency();
        curDeposit.setCurrency(curCurrency);

        return;
    }

    private void createSomeDeposit() {
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
