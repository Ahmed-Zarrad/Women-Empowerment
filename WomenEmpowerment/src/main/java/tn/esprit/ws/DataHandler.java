package tn.esprit.ws;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
public class DataHandler extends TextWebSocketHandler {

    @Override
   public void handleMessage (WebSocketSession session , WebSocketMessage<?> message) throws IOException{
        log.info("Message:{} " , message.getPayload());
        
     //   session.sendMessage(new TextMessage("atef"));
    }

}
