/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hartter.ewer.javabrain.advanced.rest.boundary;

import com.hartter.ewer.javabrain.advanced.rest.entity.MyDate;
import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author eertl
 */
@Path("date")
public class DateResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path( "{datestring}")
    public String getRequestedDate( @PathParam("datestring") MyDate datestring) {
        return "Got " + datestring;
    }
    
    @GET
    @Produces({MediaType.TEXT_PLAIN, "text/shortdate"})
    @Path("short")
    public Date getShortDate() {
        return Calendar.getInstance().getTime();
    }
}
