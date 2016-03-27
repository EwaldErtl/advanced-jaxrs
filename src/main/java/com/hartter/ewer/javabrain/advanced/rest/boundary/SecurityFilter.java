/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hartter.ewer.javabrain.advanced.rest.boundary;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.internal.util.Base64;

/**
 *
 * @author eertl
 */
@Provider
public class SecurityFilter implements ContainerRequestFilter {

    private static final String AUTH = "Authorization";
    private static final String BASIC = "Basic ";
    private static final String SEC = "secured";
    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        if ( crc.getUriInfo().getPath().contains(SEC)) {
            List<String> headers = crc.getHeaders().get(AUTH);
            if ( headers.size() > 0 ) {
                String authorization = headers.get(0);
                authorization = authorization.replace(BASIC, "");
                String decodeAsString = Base64.decodeAsString(authorization);
                StringTokenizer stringTokenizer = new StringTokenizer(decodeAsString, ":");
                String user = stringTokenizer.nextToken();
                String password = stringTokenizer.nextToken();

                if ( "user".equals(user) && "password".equals(password)) {
                    return; 
                }
            }

            Response unauthResponse = Response.status(Response.Status.UNAUTHORIZED)
                    .entity("User is not authorized")
                    .build();


            crc.abortWith(unauthResponse);
        }
    }
}
