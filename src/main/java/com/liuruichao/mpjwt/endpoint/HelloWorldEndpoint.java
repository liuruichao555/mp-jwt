package com.liuruichao.mpjwt.endpoint;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * HelloWorldEndpoint
 *
 * @author liuruichao
 * Created on 2018/6/5 11:01
 */
@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {
    @GET
    public String home() {
        return "hello";
    }
}
