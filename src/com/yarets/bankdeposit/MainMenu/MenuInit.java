package com.yarets.bankdeposit.MainMenu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MenuInit {
    private final Map<String, MainMenuCommand> menuCommands;

    public MenuInit() {
        menuCommands = new LinkedHashMap<>();
        menuCommands.put("Choose", new ChooseOption());
        menuCommands.put("Add", new AddOption());
        menuCommands.put("Search", new SearchOption());
        menuCommands.put("Delete", new DeleteOption());
        menuCommands.put("Sort", new SortOption());
        menuCommands.put("Exit", new ExitCommand());
    }

    public void doCommand(String command) {
        MainMenuCommand menuCommand = menuCommands.get(command);
        if(menuCommand != null)
            menuCommand.doCommand();
        else
            System.out.println("Введена неправильна команда!");
    }

    public Set<String> printCommand() {
        return menuCommands.keySet();
    }
}
