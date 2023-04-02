package org.test;

import io.quarkus.logging.Log;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")

public class TestResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws InterruptedException {
        Log.info("lol1 " + System.currentTimeMillis());
        System.out.println("lol1 " + System.currentTimeMillis());
        Thread.sleep(10000000);
        System.out.println("lol2 " + System.currentTimeMillis());
        Log.info("lol2 " + System.currentTimeMillis());
        return "Hello RESTEasy";
    }
}
