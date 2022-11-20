package com.yarets.bankdeposit;


import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SmtpClient;
import com.sun.net.httpserver.HttpExchange;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail {
    private final Logger logger = Logger.getLogger("MyLog");
    public void sendMailOutLook() throws FileNotFoundException {
        MailMessage message = new MailMessage();
        message.setSubject("Помилка в процесі виконання програми");
        message.setBody(readLog());
        message.setFrom(new MailAddress("stas.yarets@outlook.com", "Sender Name", false));

        message.getTo().addItem(new MailAddress("stas.yarets@outlook.com", "Recipient1", false));

        SmtpClient client = new SmtpClient();
        client.setHost("smtp-mail.outlook.com");
        client.setUsername("stas.yarets@outlook.com");
        client.setPassword("Stas2004yarets");
        client.setPort(587);
        try{
            client.send(message);
            logger.info("Повідомлення про помилку відправлене на пошту");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String readLog() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\stasy\\IdeaProjects\\BankDeposit\\logger.txt");
        Scanner sc = new Scanner(fileInputStream);
        String readMessage = "LOG:\n";
        while(sc.hasNextLine()){
            readMessage += sc.nextLine();
            readMessage += '\n';
        }
        return readMessage;

    }
}
