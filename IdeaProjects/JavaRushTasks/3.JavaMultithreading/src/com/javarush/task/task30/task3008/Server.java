package com.javarush.task.task30.task3008;

import com.javarush.task.task30.task3008.client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("введите порт:");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("сервер запущен: "+serverSocket.getLocalSocketAddress());
            while (true) {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }

        } catch (IOException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        } finally {
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }

        }
    }

    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String, Connection> pair : connectionMap.entrySet()){
            String client =         pair.getKey();
            Connection connection = pair.getValue();
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("error sending message to "+connection.toString());
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
        public void run(){
            if (socket != null && socket.getRemoteSocketAddress() != null) {
                ConsoleHelper.writeMessage("Established a new connection to a remote socket address: " + socket.getRemoteSocketAddress());
            }
            String userName = null;

            try (Connection connection = new Connection(socket)) {

                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An exchange of data error to a remote socket address");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Closed connection to a remote socket address: "); // + socketAddress);
            }
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            String userName= "";
            Message receive = null;
            while(true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                receive = connection.receive();
                if(receive.getType()!=MessageType.USER_NAME||receive.getData().isEmpty()||connectionMap.containsKey(receive.getData())){
                    continue;
                }
                userName=receive.getData();
                connectionMap.put(userName, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                break;
            }
            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String, Connection> pair : connectionMap.entrySet()){
                String user = pair.getKey();
                Connection connection1 = pair.getValue();
                if(!user.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, user));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true)
            {
                Message receive = connection.receive ( );
                if (receive.getType ( ) == MessageType.TEXT)
                {
                    Message message = new Message (MessageType.TEXT, userName + ": " + receive.getData ( ));
                    sendBroadcastMessage (message);
                }
                else
                    ConsoleHelper.writeMessage ("MessageType is not TEXT");
            }
        }
    }
}