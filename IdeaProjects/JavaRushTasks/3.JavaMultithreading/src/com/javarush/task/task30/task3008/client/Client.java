
package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by ahdpe on 29.09.2017.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() throws IOException {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException {
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            e.printStackTrace();
            clientConnected = false;
        }

    }

    public static void main(String[] args) {
        new Client().run();
    }

    public void run () {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Ошибка, выход");
            }
            if (clientConnected)
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
            else
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            while (clientConnected) {
                String text = ConsoleHelper.readString();
                if (text.toLowerCase().equals("exit")) break;
                if (shouldSendTextFromConsole())
                    sendTextMessage(text);
            }
        }
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоеденился к чату");
        }
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " покинул чат");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException {
            while (true) {
                try {
                    Message message = connection.receive();
                    if (message.getType() == MessageType.NAME_REQUEST) {
                        connection.send(new Message(MessageType.USER_NAME, getUserName()));
                    } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                        notifyConnectionStatusChanged(true);
                        return;
                    } else {
                        throw new IOException("Unexpected MessageType");
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }

        }

        public void run() {
            try {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                Client.this.connection = new Connection(socket);
                clientHandshake();
                    clientMainLoop();
            }catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
            catch (IOException e) {
                notifyConnectionStatusChanged(false);
            }
        }

    }

}
