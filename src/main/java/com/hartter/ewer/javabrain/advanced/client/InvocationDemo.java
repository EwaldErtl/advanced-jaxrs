/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hartter.ewer.javabrain.advanced.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author eertl
 */
public class InvocationDemo {
 
    public static void main(String[] args) {
        InvocationDemo demo = new InvocationDemo();
        Invocation prepareRequestForMessagesByYear = demo.prepareRequestForMessagesByYear(2015);
        Response invoke = prepareRequestForMessagesByYear.invoke();
        System.out.println(invoke.getStatus());
    }

    public Invocation prepareRequestForMessagesByYear(int year) {
        Client client = ClientBuilder.newClient();
        
        WebTarget msgTarget = client.target("http://localhost:8080/webapi/messages");
        
        return msgTarget.queryParam("year", year)
                .request(MediaType.APPLICATION_JSON)
                .buildGet();
    }
    
}
