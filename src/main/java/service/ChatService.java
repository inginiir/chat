package service;

import sockets.ChatWebSocket;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatService {

    private Set<ChatWebSocket> webSockets;

    public ChatService() {
        this.webSockets = Collections.newSetFromMap(new ConcurrentHashMap<>());
    }

    public void remove(ChatWebSocket chatWebSocket) {
        webSockets.remove(chatWebSocket);
    }

    public void sendMessage(String data) {
        for (ChatWebSocket ws: webSockets) {
            try {
                ws.sendString(data);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void add(ChatWebSocket chatWebSocket) {
        webSockets.add(chatWebSocket);
    }
}
