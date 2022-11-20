package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.CurrencyEnum;
import com.yarets.bankdeposit.deposit.DefaultDeposit;
import org.mockito.Mock;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ReadFileOption implements MainMenuCommand{
    private DefaultDeposit defaultDepositRead = new DefaultDeposit();
    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\stasy\\IdeaProjects\\BankDeposit\\inputData.txt");
            Scanner sc = new Scanner(fileInputStream);
            while(sc.hasNextLine()){
                defaultDepositRead = DefaultDeposit.builder()
                        .setCompanyName(sc.nextLine())
                        .setDepositName(sc.nextLine())
                        .setPercentage(Double.valueOf(sc.nextLine()))
                        .build();
                defaultDepositRead.setAmountMoney(Integer.valueOf(sc.nextLine()));
                defaultDepositRead.setTermOfDeposit(Integer.valueOf(sc.nextLine()));
                defaultDepositRead.setEarlyTerm(Integer.valueOf(sc.nextLine()));
                defaultDepositRead.setEarlyAmount(Double.valueOf(sc.nextLine()));
                defaultDepositRead.setMonthlyCapitalization(Integer.valueOf(sc.nextLine()));
                defaultDepositRead.setAmountMonthlyAdd(Integer.valueOf(sc.nextLine()));
                defaultDepositRead.setCurrency(CurrencyEnum.valueOf(sc.nextLine()));
            }
            sc.close();
            defaultDepositRead.calcInvest();
            System.out.println("Запис проведено успішно");
            listDeposit.add(defaultDepositRead);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Logger logger = Logger.getLogger("MyLog");
        logger.info("Читаємо файл");

    }
}
