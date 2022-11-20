package com.yarets.bankdeposit;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Logger;

import static java.lang.System.in;

public class DataInput {
    //private Scanner sc = new Scanner(in);
    private static final Scanner sc = new Scanner(System.in);
    private final Logger logger = Logger.getLogger("MyLog");

    public DataInput() {

}

    public int inputInt(){
        return inputInt(retInt -> retInt <= 0);
    }

    public int inputOneZero(){
        return inputInt(retInt -> retInt != 1 && retInt != 0);
    }

    public int inputMore(int minInt){
        return inputInt(retInt -> retInt <= 0 || retInt > minInt);
    }

    public int inputLess(int minInt){
        return inputInt(retInt -> retInt <= 0 || retInt < minInt);
    }

    public double inputDouble(){
        return inputDouble(retDouble -> retDouble <= 0);
    }

    public CurrencyEnum inputCurrency(){
        SendMail sendMail = new SendMail();
        boolean goodData = false;
        Scanner sc = new Scanner(System.in);
        CurrencyEnum retCur = CurrencyEnum.UAH;
        for(CurrencyEnum ctn : CurrencyEnum.values()){
            System.out.println(ctn);
        }
        while(!goodData){
            try{
                System.out.println("Введіть:");
                String tmpCur = sc.next();
                retCur = CurrencyEnum.valueOf(tmpCur);
                goodData = true;
            }catch (IllegalArgumentException ex){
                System.out.println("Введена неправильна команда");
                logger.warning("Помилка вводу");
                try {
                    sendMail.sendMailOutLook();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return retCur;
    }

    private double inputDouble(Predicate<Double> pared){
        return input(sc::nextDouble, pared);
    }
    private int inputInt(Predicate<Integer> pared){
        return input(sc::nextInt, pared);
    }

    private <T> T input(Supplier<T> supplier, Predicate<T> predicate){
        SendMail sendMail = new SendMail();
        boolean goodData = false;
        T value = null;
        while(!goodData){
            try{
                System.out.println("Введіть: ");
                value = supplier.get();
                if(predicate.test(value))
                    throw new IllegalArgumentException();
                goodData = true;
            } catch (InputMismatchException ex){
                System.out.println("Введена неправильна команда");
                sc.next();
                logger.warning("Помилка вводу");
                try {
                    sendMail.sendMailOutLook();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            catch (IllegalArgumentException ex){
                System.out.println("Введена неправильна команда");
                logger.warning("Помилка вводу");
                try {
                    sendMail.sendMailOutLook();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return value;
    }
}
