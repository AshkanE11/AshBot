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



public class AshBot extends TelegramLongPollingBot {




    // Global Variables

    String userText ;
    String userSubhead , userMessage ;
    long ChatId ;
    SendMessage botText , botInstruct ;




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

                botText = new SendMessage().setChatId(ChatId).setText("Sooo ... What We Are Going To Do ?!? \n Tip: Use The KeyBoard Commands ...") ;









            }



            else if (update.getMessage().getText().equals("/Mail")) {



                // ChatId

                long chatId = update.getMessage().getChatId() ;

                // UserText

                String userText = update.getMessage().getText() ;

                // BotText

                botText = new SendMessage().setChatId(chatId).setText("Ha Nice ! \n Started the Mailing Operation ...") ;







                /* Bot Instructions &&& User Interfaces &&& Data Capturing */






                    // Get SubHeader

                    botInstruct = new SendMessage().setChatId(chatId).setText("Give Me Your Mail SubHead !!!");

                    userSubhead = update.getMessage().getText().toString();


                    // Get Users Text

                    botInstruct = new SendMessage().setChatId(chatId).setText("Listening ... \n Enter Your Message For Ashkan !!!");

                    userMessage = update.getMessage().getText().toString();





            }




            else { botText = new SendMessage().setChatId(ChatId).setText("Use The Command Keys ...") ; }




        }







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











        // Finalizing Output of The Robot ...


        try {

            execute(botText) ;
            execute(botInstruct) ;

        }

        catch (TelegramApiException apiException) {

            apiException.printStackTrace();

            Logger.getLogger(AshBot.class.getName()).log(Level.SEVERE , null , apiException);

        }





    }



}
