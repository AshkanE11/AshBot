package com.aeteams.AshBot;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot ;
import org.telegram.telegrambots.api.methods.send.SendMessage ;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AshBot extends TelegramLongPollingBot {


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



        // ChatId

        long chatId = update.getMessage().getChatId() ;

        // UserText

        String userText = update.getMessage().getText() ;

        // BotOutput

        SendMessage botText = new SendMessage().setChatId(chatId).setText("userText") ;




        // Finalizing Output of The Robot ...


        try {

            execute(botText) ;
            
        }

        catch (TelegramApiException apiException) {

            apiException.printStackTrace();

            Logger.getLogger(AshBot.class.getName()).log(Level.SEVERE , null , apiException);

        }





    }



}
