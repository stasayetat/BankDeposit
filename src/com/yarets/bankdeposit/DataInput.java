package com.yarets.bankdeposit;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DataInput {

    public int inputInt(){
        boolean goodData = false;
        Scanner sc = new Scanner(System.in);
        int retInt = 0;
        while (!goodData){
            try{
                System.out.println("Введіть:");
                retInt = sc.nextInt();
                if(retInt <= 0)
                    throw new IllegalArgumentException();
                goodData = true;
            } catch (InputMismatchException ex) {
                System.out.println("Введена неправильна команда");
                sc.next();
                continue;
            }
            catch (IllegalArgumentException ex){
                System.out.println("Введена неправильна команда");
                continue;
            }
        }
        return retInt;
    }

    public int inputOneZero(){
        boolean goodData = false;
        Scanner sc = new Scanner(System.in);
        int retOneZero = 0;
        while(!goodData){
            try{
                System.out.println("Введіть:");
                retOneZero = sc.nextInt();
                if(retOneZero != 1 && retOneZero != 0)
                    throw new IllegalArgumentException();
                goodData = true;
            }catch (InputMismatchException ex) {
                System.out.println("Введена неправильна команда");
                sc.next();
                continue;
            }
            catch (IllegalArgumentException ex){
                System.out.println("Введена неправильна команда");
                continue;
            }
        }
        return  retOneZero;
    }

    public int inputMore(int minInt){
        boolean goodData = false;
        Scanner sc = new Scanner(System.in);
        int retMore = 0;
        while(!goodData){
            try{
                System.out.println("Введіть:");
                retMore = sc.nextInt();
                if( retMore <= 0 || retMore > minInt)
                    throw new IllegalArgumentException();
                goodData = true;
            }catch (InputMismatchException ex) {
                System.out.println("Введена неправильна команда");
                sc.next();
                continue;
            }
            catch (IllegalArgumentException ex){
                System.out.println("Введена неправильна команда");
                continue;
            }
        }
        return retMore;
    }

    public int inputLess(int minInt){
        boolean goodData = false;
        Scanner sc = new Scanner(System.in);
        int retLess = 0;
        while(!goodData){
            try{
                System.out.println("Введіть:");
                retLess = sc.nextInt();
                if( retLess <= 0 || retLess < minInt)
                    throw new IllegalArgumentException();
                goodData = true;
            }catch (InputMismatchException ex) {
                System.out.println("Введена неправильна команда");
                sc.next();
                continue;
            }
            catch (IllegalArgumentException ex){
                System.out.println("Введена неправильна команда");
                continue;
            }
        }
        return retLess;
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

    public double inputDouble(){
        boolean goodData = false;
        Scanner sc = new Scanner(System.in);
        double retDouble = 0;
        while(!goodData){
            try {
                System.out.println("Введіть:");
                retDouble = sc.nextDouble();
                if(retDouble <= 0)
                    throw new IllegalArgumentException();
                goodData = true;
            }catch (InputMismatchException ex) {
                System.out.println("Введена неправильна команда");
                sc.next();
                continue;
            }
            catch (IllegalArgumentException ex){
                System.out.println("Введена неправильна команда");
                continue;
            }
        }
        return retDouble;
    }

}
