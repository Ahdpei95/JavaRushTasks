package com.javarush.task.task30.task3008.client;


import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class BotClient extends Client {

    // private String welcome = "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.";

    public static void main(String[] args) {
        new BotClient().run();
    }

    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    protected String getUserName() throws IOException {
        return "date_bot_" + (int) (Math.random() * 100);
    }


    public class BotSocketThread extends Client.SocketThread {

        @Override
        protected void processIncomingMessage(String message) {
                //19.2.1.
                ConsoleHelper.writeMessage(message);
                //19.2.2.
                String[] messageParts = message.split(": ");
                if (messageParts.length == 2) {
                    String messageAuthor = messageParts[0];
                    String messageText = messageParts[1].toLowerCase();
                    String dateFormat = null;
                    switch (messageText) {
                        case "дата":
                            dateFormat = "d.MM.YYYY";
                            break;
                        case "день":
                            dateFormat = "d";
                            break;
                        case "месяц":
                            dateFormat = "MMMM";
                            break;
                        case "год":
                            dateFormat = "YYYY";
                            break;
                        case "время":
                            dateFormat = "H:mm:ss";
                            break;
                        case "час":
                            dateFormat = "H";
                            break;
                        case "минуты":
                            dateFormat = "m";
                            break;
                        case "секунды":
                            dateFormat = "s";
                            break;
                    }
                    if (dateFormat != null) {
                        String reply = String.format("Информация для %s: %s",
                                messageAuthor,
                                new SimpleDateFormat(dateFormat).format(Calendar.getInstance().getTime())
                        );
                        sendTextMessage(reply);
                    }
                }
            }

        @Override
        protected void clientMainLoop () throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }
}
