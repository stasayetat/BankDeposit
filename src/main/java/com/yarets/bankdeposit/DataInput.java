package com.yarets.bankdeposit;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.System.in;

public class DataInput {
    private static final Scanner sc = new Scanner(in);

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
            }
            catch (IllegalArgumentException ex){
                System.out.println("Введена неправильна команда");
            }
        }
        return value;
    }
}
