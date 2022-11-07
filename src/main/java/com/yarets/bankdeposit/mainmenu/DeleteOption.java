package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.DataInput;
import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.util.List;
import java.util.Scanner;

public class DeleteOption implements MainMenuCommand {

    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
        DataInput dpi = new DataInput();
        if(listDeposit.isEmpty()){
            System.out.println("Немає чого видаляти D:");
            return;
        }
        System.out.println("Виберіть депозит, який хочете видалити: ");
        for(int i = 0; i < listDeposit.size(); i++){
            System.out.println(i+1 + ":" + listDeposit.get(i));
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть індекс обраного депозиту");
        int indDep = dpi.inputMore(listDeposit.size());
        listDeposit.remove(indDep-1);

        System.out.println("Депозити, які залишилися: ");
        for(int i = 0; i < listDeposit.size(); i++){
            System.out.println(i+1 + ":" + listDeposit.get(i));
        }
    }
}
