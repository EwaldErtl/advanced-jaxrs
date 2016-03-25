/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hartter.ewer.javabrain.advanced.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.koushik.javabrains.messenger.model.Message;

/**
 *
 * @author eertl
 */
public class Main {
 
    public static void main(String[] argv) {
        Client client = ClientBuilder.newClient();
        
        WebTarget baseTarget = client.target("http://localhost:8080/webapi");
        WebTarget messagesTarget = baseTarget.path("messages");
        WebTarget singleMessage = messagesTarget.path("{msgId}");
        Message msg1 = singleMessage.resolveTemplate("msgId", 1).request().get().readEntity(Message.class);
        Message msg2 = singleMessage.resolveTemplate("msgId", 2).request().get().readEntity(Message.class);
        System.out.println(msg1.getMessage());
        System.out.println(msg2.getMessage());
        
        Message msgNew = new Message(4, "post", "ewald");
        
        Response postResponse = messagesTarget.request().post(Entity.json(msgNew));
        Message postMessage = postResponse.readEntity(Message.class);
        System.out.println("PostResponse " + postResponse);
        System.out.println("postMsg " + postMessage.getMessage());
    }
}
