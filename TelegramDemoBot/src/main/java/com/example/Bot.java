package com.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot
{
	
	@Override
	public void onUpdateReceived(Update update) 
	{
		if(update.hasMessage())
		{
			String msg=update.getMessage().getText();
			if(msg.equals("start"))
			{
				//SendMessage amsg=new SendMessage (Long.toString(chatId),text);
				sendmsg(update.getMessage().getChatId(),"Bot Started!");
			}
			if(msg.equals("hello"))
			{
			sendmsg(update.getMessage().getChatId(),"Hello "+update.getMessage().getFrom().getFirstName());
			}
			if(msg.equals("chat"))
			{
			sendmsg(update.getMessage().getChatId(),"let's chat");
			}

			
			//set image
			if (msg.equals("cat")) 
	        {
				SendPhoto pic=new SendPhoto(update.getMessage().getChatId().toString(),new InputFile( "https://unsplash.com/photos/a-close-up-of-a-cat-looking-at-the-camera-Hzu0-51klr4"));
				try 
				{
					execute(pic);
				}
					catch (TelegramApiException e) 
				{
						e.printStackTrace();
				}
			
	        }
			
			if (msg.equals("video")) 
	        {
				SendVideo video=new SendVideo(update.getMessage().getChatId().toString(),new InputFile( "https://youtu.be/jDhsAT8FNLs?si=CPztJFmFWbCjgOwu"));
				try 
				{
					execute(video);
				}
				catch (TelegramApiException e) 
				{
					e.printStackTrace();
				}	       
	        }
		
		}
	
	}

	//method 
	private void sendmsg(Long chatId, String text)
	{
		SendMessage msg=new SendMessage (Long.toString(chatId),text);
      	try 
      	{
			execute(msg);
		} catch (TelegramApiException e) 
      	{
			e.printStackTrace();
		}	
	}

	@Override
	public String getBotUsername() 
	{
		return "ststele23bot";
	}
	
	@Override
	public String getBotToken()
	{
		return "7952259123:AAHGi3kvBB13HfuKRZEAsJfcH8jtmAgJ7Uo";
	}

}
