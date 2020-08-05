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

        SendMessage botWel = new SendMessage().setChatId(chatId).setText("Sooo ... What We Are Going To Do ?!?") ;





        // Commands Reply


        ReplyKeyboardMarkup keymark = new ReplyKeyboardMarkup() ;
        List<KeyboardRow> rowlist = new ArrayList<>() ;
        KeyboardRow keyrow1 = new KeyboardRow() ;
        KeyboardRow keyrow2 = new KeyboardRow() ;
        KeyboardRow keyrow3 = new KeyboardRow() ;
        KeyboardRow keyrow4 = new KeyboardRow() ;
        keyrow1.add("ONE") ;
        keyrow2.add("TWO") ;
        keyrow3.add("THREE") ;
        keyrow4.add("FOUR") ;
        rowlist.add(keyrow1) ;
        rowlist.add(keyrow2) ;
        rowlist.add(keyrow3) ;
        rowlist.add(keyrow4) ;
        keymark.setKeyboard(rowlist) ;
        keymark.setResizeKeyboard(true) ;







        // Finalizing Output of The Robot ...


        try {

            execute(botWel) ;

        }

        catch (TelegramApiException apiException) {

            apiException.printStackTrace();

            Logger.getLogger(AshBot.class.getName()).log(Level.SEVERE , null , apiException);

        }





    }



}
