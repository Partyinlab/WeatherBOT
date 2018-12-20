package bottt;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;



import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class SomeBot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new SomeBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "SomeBotOnceToldbot";
    }

    @Override
    public String getBotToken() {
        return "735318728:AAEVX_IUvvXWeCLEp7";
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/start":
                    sendMsg(message, "Назовите город");
                    System.out.println(message.getText());
                    break;
                case "На сегодня":
                    sendMsg(message, "test7");
                    System.out.println(message.getText());
                    break;
                case "На неделю":
                    sendMsg(message, "На неделю");
                    System.out.println(message.getText());
                    break;
                default:
                	String messageText = "";
                	if ( checkCity(message.getText()))
                	{
                		messageText = getWeatherData(message.getText());
                	}
                    sendMsg(message, messageText);
                    System.out.println(message.getText());
                    break;
            }
        }
    }
    
    public boolean checkCity (String cityName)
    {
    	return true;
    	
    }
    
    public String getWeatherData(String cityName)
    {
    	return "+7*C, облачно, без осадков";
    }

    public void sendMsg (Message message, String text) {
    	SendMessage s = new SendMessage();
		s.setChatId(message.getChatId());
		s.setText(text);
		try {  
			sendMessage(s);
		} catch (TelegramApiException e){
			e.printStackTrace();
		}
    }

}

