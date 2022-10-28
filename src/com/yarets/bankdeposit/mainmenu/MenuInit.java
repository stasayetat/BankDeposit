package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.Deposits.DefaultDeposit;

import java.util.*;

public class MenuInit {
    private final Map<String, MainMenuCommand> menuCommands;

    protected List<DefaultDeposit> actualDeposit = new ArrayList<>();

    public MenuInit() {
        menuCommands = new LinkedHashMap<>();
        menuCommands.put("Choose", new ChooseOption());
        menuCommands.put("Add", new AddOption());
        menuCommands.put("Print", new CurrentOption());
        menuCommands.put("Search", new SearchOption());
        menuCommands.put("Delete", new DeleteOption());
        menuCommands.put("Sort", new SortOption());
        menuCommands.put("Exit", new ExitCommand());
    }

    public void doCommand(String command) {
        MainMenuCommand menuCommand = menuCommands.get(command);
        if(menuCommand != null)
            menuCommand.doCommand(actualDeposit);
        else
            System.out.println("Введена неправильна команда!");
    }

    public Set<String> printCommand() {
        return menuCommands.keySet();
    }


}
