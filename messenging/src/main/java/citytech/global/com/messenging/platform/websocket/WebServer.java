package citytech.global.com.messenging.platform.websocket;
import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;

@ServerWebSocket("/chat/{username}")
public class WebServer {
    private final WebSocketBroadcaster broadcaster;

    public WebServer(WebSocketBroadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }

    @OnOpen
    public void onOpen(String username, WebSocketSession session) {
        broadcaster.broadcast("User " + username + " joined the chat.");
    }

    @OnMessage
    public void onMessage(String message, WebSocketSession session) {
        broadcaster.broadcast(message);
    }

    @OnClose
    public void onClose(String username, WebSocketSession session) {
        broadcaster.broadcast("User " + username + " left the chat.");
    }
}
