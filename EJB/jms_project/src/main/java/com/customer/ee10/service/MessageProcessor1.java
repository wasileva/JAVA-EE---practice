/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.ee10.service;


import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName="jms/T1")
public class MessageProcessor1 implements MessageListener{
    // можем внедрять ресурсы     
    
    // метод вызвается контейнером (мы не вызываем данный метод!!!)
    @Override
    public void onMessage(Message msg) {
        try {            
            System.out.println("MessageProcessor1.onMessage.ID=" + msg.getJMSMessageID());
            // получаем тело сообщение 
            String textMessage = msg.getBody(String.class); 
            System.out.println("MessageProcessor1.textMessage=" + textMessage);
            // 
            String propValue = msg.getStringProperty("prop1"); 
            if(propValue!=null){
                System.out.println("onMessage.propValue=" + propValue);            
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }    
}
