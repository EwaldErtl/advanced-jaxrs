/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hartter.ewer.javabrain.advanced.client;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.koushik.javabrains.messenger.model.Message;

/**
 *
 * @author eertl
 */
public class GenericDemo {
        
    
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();        
        List<Message> messages = client.target("http://localhost:8080/webapi")
                .path("messages")
                .queryParam("year", 2016)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Message>>() { });
        
        System.out.println(messages);
        
    }
}
