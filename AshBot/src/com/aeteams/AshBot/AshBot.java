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





    // Commands ...



    String Start = "/Start" ;
    String Mail = "/Mail" ;
    String History = "/History" ;
    String Overview = "/Overview" ;
    String About = "/About" ;



    // Global Variables ...


    String userInput;
    SendMessage botText ;
    String mailHead , mailBody ;
    long ChatId ;

    long mailcounter ;







    // Bot Instructs ...


    String startIns = "Sooo ... \n What We Are Going To Do !??" ;
    String mailIns1 = "Mailing Operation Started ..." ;
    String mailIns2 = "Enter Your Mail SubHead : " ;
    String mailIns3 = "Listening ... \n Say Your Main Message : " ;
    String mailIns4 = "Mail Generated and Have Been \n Sent Successfully !" ;
    String overviewIns = "-----Overview----- \n \n Total Mails Sent :  \n " ;
    String aboutIns = "AshBot is a Telegram Bot which gets \n user text and convert it as \n an Email and send it to \n a specified target mail ..." ;
    String err = "Use The Command Line ..." ;





    @Override
    public String getBotToken() { return "1188286735:AAGLOSg8Czz8hRz9llt144ZhsaSg7Zm7q6E"; }


    @Override
    public String getBotUsername() { return "AshkanEBot"; }





    AshBot ashbot = new AshBot() ;



    @Override
    public void onUpdateReceived(Update update) {




        ChatId = update.getMessage().getChatId() ;

        botText = new SendMessage().setChatId(ChatId) ;

        userInput = update.getMessage().getText().toString() ;


        boolean hasMessage = update.hasMessage() ;
        boolean hasText = update.getMessage().hasText() ;




        if (hasMessage && hasText) {


            // Start Case ...

            if (userInput.equals(Start)) {


                // Welcome Text

                botText.setText(startIns);
                try { execute(botText) ; } catch (TelegramApiException apiException) { apiException.printStackTrace(); }


            }


            // Mailing Case

            else if (userInput.equals(Mail)) {


                // Bot Text ONE

                botText.setText(mailIns1);

                try { execute(botText) ; } catch (TelegramApiException apiException) { apiException.printStackTrace(); }




                // Bot Text TWO

                botText.setText(mailIns2);

                try { execute(botText) ; } catch (TelegramApiException apiException) { apiException.printStackTrace(); }


                // User Input ONE

                mailHead = userInput;

                botText.setText(mailIns3);


                // User Input TWO

                mailBody = userInput;

                botText.setText(mailIns4);



                // Counter ...

                mailcounter++;



            }


            // History Case ...


            else if (userInput.equals(History)) {

                botText.setText("Nothing To Show !!!") ;

            }



            // Overview Case ...


            else if (userInput.equals(Overview)) { botText.setText(overviewIns + mailcounter); }


            // About Case ...


            else if (userInput.equals(About)) {

                botText.setText(aboutIns);
                try { execute(botText) ; } catch (TelegramApiException apiException) { apiException.printStackTrace(); }

            }


            // Else Case ...

            else {

                botText.setText(err);
                try { execute(botText) ; } catch (TelegramApiException apiException) { apiException.printStackTrace(); }

            }













            // Commands Reply


            ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyrow = new ArrayList<>();
            KeyboardRow Mail = new KeyboardRow();
            KeyboardRow Overview = new KeyboardRow();
            KeyboardRow History = new KeyboardRow();
            KeyboardRow About = new KeyboardRow();
            Mail.add("/Mail");
            Overview.add("/Overview");
            History.add("/History");
            About.add("/About");
            keyrow.add(Mail);
            keyrow.add(Overview);
            keyrow.add(History);
            keyrow.add(About);
            keyboard.setKeyboard(keyrow);
            keyboard.setResizeKeyboard(true);
            keyboard.setOneTimeKeyboard(false);
            keyboard.setSelective(true);





        }











        // Finalizing Output of The Robot ...  /**** Delete Checkout ****\ **************************************************************************


        try {

            execute(botText) ;

        }

        catch (TelegramApiException apiException) {

            apiException.printStackTrace();

            Logger.getLogger(AshBot.class.getName()).log(Level.SEVERE , null , apiException);

        }












    }













}
