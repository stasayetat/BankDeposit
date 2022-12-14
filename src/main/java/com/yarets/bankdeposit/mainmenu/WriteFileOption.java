package com.yarets.bankdeposit.mainmenu;

import com.yarets.bankdeposit.deposit.DefaultDeposit;

import java.io.*;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class WriteFileOption implements MainMenuCommand {

    @Override
    public void doCommand(List<DefaultDeposit> listDeposit) {
            String consoleOutPut = null;
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1000);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);
            PrintOption printOption = new PrintOption();
            printOption.doCommand(listDeposit);
            capture.flush();
            consoleOutPut = outputStream.toString();
            System.setOut(originalOut);
        try {
            FileOutputStream outputFile = new FileOutputStream("C:\\Users\\stasy\\IdeaProjects\\BankDeposit\\outputData.txt");
            byte[] strToBytes = consoleOutPut.getBytes();
            outputFile.write(strToBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Запис успішно проведено!");
        Logger logger = Logger.getLogger("MyLog");
        logger.info("Пишемо в файл");
    }
}
