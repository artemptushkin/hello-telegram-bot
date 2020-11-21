package io.github.artemptushkin.hello.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
	public static void main(String[] args) throws Exception {
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
		telegramBotsApi.registerBot(new TelegramLongPollingBot() {
			@Override
			public void onUpdateReceived(Update update) {
				if (update.hasMessage() && update.getMessage().hasText()) {
					SendMessage message = new SendMessage();
					message.setChatId(update.getMessage().getChatId().toString());
					message.setText("hello!");
					try {
						execute(message); // Call method to send the message
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
			}

			@Override
			public void clearWebhook() throws TelegramApiRequestException {

			}

			@Override
			public String getBotUsername() {
				return "BestAuditorBot";
			}

			@Override
			public String getBotToken() {
				return "1414406373:AAHI5ZD2vZxgx81TuoVqrz7Fip1Cq7eL1xk";
			}
		});
	}
}
