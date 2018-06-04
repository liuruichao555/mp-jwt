package com.liuruichao.mpjwt;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.springframework.stereotype.Component;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * ExternalFacade
 *
 * @author liuruichao
 * Created on 2018/6/4 17:48
 */
@Component
@Path("/user")
@DenyAll
@RequestScoped
public class UserFacade {
    @Inject
    private JsonWebToken jsonWebToken;

    @GET
    @RolesAllowed({"hehe"})
    public String hello() {
        return "hello";
    }
}
