/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hartter.ewer.javabrain.advanced.rest.boundary;

import com.hartter.ewer.javabrain.advanced.rest.entity.MyDate;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author eertl
 */
@Path("date/{datestring}")
public class DateResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getRequestedDate( @PathParam("datestring") MyDate datestring) {
        return "Got " + datestring;
    }
}
