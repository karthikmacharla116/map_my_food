package com.mapmyfood.util;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.jms.core.JmsTemplate;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Message;

public class MessageUtil {
    private final JmsTemplate jmsTemplate;
    private final ConnectionFactory connectionFactory;

    public MessageUtil(ConnectionFactory connectionFactory, JmsTemplate jmsTemplate) {
        this.connectionFactory = connectionFactory;
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    public Message receiveMessage(String destination) {
        return jmsTemplate.receive(destination);
    }

    public void triggerOrderPlacedMessage() {
        // Assuming you have a destination named "OrderPlacedQueue"
        String destination = "OrderPlacedQueue";
        String message = "Food ordered";

        // Send the order placed message
        sendMessage(destination, message);

        // Start a timer for 5 minutes to trigger the order delivered message
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                triggerOrderDeliveredMessage();
                timer.cancel(); // Cancel the timer after triggering the message
            }
        }, 5 * 60 * 1000); // 5 minutes in milliseconds
    }

    public void triggerOrderDeliveredMessage() {
        // Assuming you have a destination named "OrderDeliveredQueue"
        String destination = "OrderDeliveredQueue";
        String message = "Food delivered";

        // Send the order delivered message
        sendMessage(destination, message);
    }
}
