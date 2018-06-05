package com.liuruichao.mpjwt.endpoint;


import com.liuruichao.mpjwt.TokenUtils;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
//import javax.enterprise.context.ApplicationScoped;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * UserEndpoint
 *
 * @author liuruichao
 * Created on 2018/6/4 18:26
 */
@ApplicationScoped
@DeclareRoles({"ViewBalance", "Debtor", "Creditor", "Debtor2", "BigSpender"})
@Path("/user")
public class UserEndpoint {
    @Inject
    private JsonWebToken jsonWebToken;

    @GET
    public String login(@QueryParam("username") String username, @QueryParam("password") String password) throws Exception {
        if (username.equals("liuruichao") && password.equals("liuruichao123")) {

            String token = TokenUtils.generateTokenString("/token1.json");
            System.out.println(token);
            return "success";
        }
        return "fail";
    }

    @POST
    @RolesAllowed({"ViewBalance"})
    public String getBalance() {
        System.out.println(jsonWebToken.getRawToken());
        return "100";
    }
}
