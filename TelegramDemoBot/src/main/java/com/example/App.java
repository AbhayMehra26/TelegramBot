package com.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App 
{
    public static void main( String[] args )
 {
      try 
      {
       TelegramBotsApi telegramBotsApi=new TelegramBotsApi(DefaultBotSession.class);
       telegramBotsApi.registerBot(new Bot ());
       System.out.println("Bot start Successfully");
      } 
      catch (TelegramApiException e) 
     {
       e.printStackTrace();
     }
  } 
}
