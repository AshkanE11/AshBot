package com.aeteams.AshBot;



import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot ;
import org.telegram.telegrambots.api.methods.send.SendMessage ;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.*;
import javax.jms.Message;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;



public class AshBot extends TelegramLongPollingBot {




    // Global Variables

    String userText ;
    String userSubhead , userMessage ;
    long ChatId ;
    SendMessage botText ;
    SendMessage botMailInstruct1 , botMailInstruct2 , botMailInstruct3 ;
    SendMessage botAboutInstruct ;




    @Override
    public String getBotToken() {
        return "1188286735:AAGLOSg8Czz8hRz9llt144ZhsaSg7Zm7q6E";
    }


    @Override
    public String getBotUsername() {
        return "AshkanEBot";
    }


    @Override
    public void onUpdateReceived(Update update) {



        if (update.hasMessage() && update.getMessage().hasText()) {



            if (update.getMessage().getText().equals("/start")) {






                // ChatId

                ChatId = update.getMessage().getChatId() ;

                // UserText

                userText = update.getMessage().getText() ;

                // BotOutput

                botText = new SendMessage().setChatId(ChatId).setText("Sooo ... \n What We Are Going To Do ?!?") ;









            }



            else if (update.getMessage().getText().equals("/Mail")) {



                // ChatId

                long chatId = update.getMessage().getChatId() ;

                // UserText

                String userText = update.getMessage().getText() ;

                // BotText

                botText = new SendMessage().setChatId(chatId).setText("Nice ! \n Started the Mailing Operation ...") ;







                /* Bot Instructions &&& User Interfaces &&& Data Capturing */






                    // Get SubHeader

                    botMailInstruct1 = new SendMessage().setChatId(chatId).setText("Give Me Your Mail SubHead !!!");

                    userSubhead = update.getMessage().getText().toString();


                    // Get Users Message

                    botMailInstruct2 = new SendMessage().setChatId(chatId).setText("Listening ... \n Enter Your Message For Ashkan !!!");

                    userMessage = update.getMessage().getText().toString();


                    // Operation Done Successfully !!!


                    botMailInstruct3 = new SendMessage().setChatId(chatId).setText("Thinking ...") ;










            }



            else if (update.getMessage().getText().equals("/About")) {


                botAboutInstruct = new SendMessage().setChatId(ChatId).setText("AshBot is an Open Source Telegram Bot Which Uses a Friendly User Interface Authorized in Java \n" +
                        "That Catches User Input and Easily Convert It To an Email and Send It as an Mail To a Specified Mail Target Using SMTP Mailing by Java Mailing API \n" +
                        "Developed With LOVE By Ashkan Ebtekari \n" +
                        "GitHub: AshkanE11 ") ;





            }




            else { botText = new SendMessage().setChatId(ChatId).setText("Use The Command Keys ...") ; }





            // Commands Reply



            ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup() ;
            List<KeyboardRow> keyrow = new ArrayList<>() ;
            KeyboardRow Mail = new KeyboardRow() ;
            KeyboardRow Overview = new KeyboardRow() ;
            KeyboardRow History = new KeyboardRow() ;
            KeyboardRow About = new KeyboardRow() ;
            Mail.add("/Mail") ;
            Overview.add("/Overview") ;
            History.add("/History") ;
            About.add("/About") ;
            keyrow.add(Mail) ;
            keyrow.add(Overview) ;
            keyrow.add(History) ;
            keyrow.add(About) ;
            keyboard.setKeyboard(keyrow) ;
            keyboard.setResizeKeyboard(true) ;
            keyboard.setOneTimeKeyboard(false) ;
            keyboard.setSelective(true) ;





        }





        class SMTPMailing {





            // Credentials ...


            String from = "ashkanebtekari@gmail.com" ; // Hosting Mail
            String to = "ranvividly@gmail.com" ;  // Target Mail !!!
            String host = "192.168.1.86" ; // IP Adress || LocalHost




            //Get the session object


            Properties properties = System.getProperties();
        properties.setProperty("smtp.gmail.com", host);
            Session session = Session.getDefaultInstance(properties) ;


            // Finalizing The Mail ...


        try{



                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(javax.mail.Message.RecipientType.TO , new InternetAddress(to));
                message.setSubject("Ping");
                message.setText("My Message Here !!!");



                // Sending message


                Transport.send(message);
                System.out.println("Sending Operation Done Successfully ...");



            }


        catch (MessagingException mex) { mex.printStackTrace() ; }


        }




















        // Finalizing Output of The Robot ...


        try {

            execute(botText) ;
            execute(botMailInstruct1) ;
            execute(botMailInstruct2) ;
            execute(botMailInstruct3) ;
            execute(botAboutInstruct) ;

        }

        catch (TelegramApiException apiException) {

            apiException.printStackTrace();

            Logger.getLogger(AshBot.class.getName()).log(Level.SEVERE , null , apiException);

        }





    }



}
