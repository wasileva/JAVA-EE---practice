package com.customer.ee10.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.Topic;

@Stateless
public class SenderService {
    
    @Inject
    JMSContext context;
    
    @Resource(lookup="jms/T1")
    private Topic t1;
    
    public void sendTextMessage(String text){   
        JMSProducer producer = context.createProducer();
        System.out.println("SenderService.sendTextMessage = " + text);
        
        try {
            producer.send(t1, createTextMessage(text, "prop1", "value1"));
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    
    private Message createTextMessage(String text, String propName, String propValue) throws JMSException {
        TextMessage msg = context.createTextMessage();
        msg.setText(text);
        msg.setStringProperty(propName, propValue);
        return msg;
    }
}
