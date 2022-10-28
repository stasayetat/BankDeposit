package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;

import java.util.List;
import java.util.Scanner;

public class DeleteOption implements MainMenuCommand {

    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        if(listDeposit.isEmpty()){
            System.out.println("Немає чого видаляти D:");
            return;
        }
        System.out.println("Виберіть депозит, який хочете видалити: ");
        for(int i = 0; i < listDeposit.size(); i++){
            System.out.println(i+1 + ":" + listDeposit.get(i));
        }
        Scanner sc = new Scanner(System.in);

        boolean goodData = false;
        int indDep = 0;


        while (!goodData){
            System.out.println("Введіть індекс обраного депозиту");
            try{
                indDep = sc.nextInt();
                listDeposit.remove(indDep-1);
                goodData = true;
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Введена неправильна команда");
            }
        }
        if(listDeposit.isEmpty()){
            System.out.println("Нічого немає D:");
            return;
        }

        System.out.println("Депозити, які залишилися: ");
        for(int i = 0; i < listDeposit.size(); i++){
            System.out.println(i+1 + ":" + listDeposit.get(i));
        }
    }
}
