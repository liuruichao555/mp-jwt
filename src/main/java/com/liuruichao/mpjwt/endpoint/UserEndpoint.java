package com.liuruichao.mpjwt.endpoint;


import com.liuruichao.mpjwt.TokenUtils;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
//import javax.enterprise.context.ApplicationScoped;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Set;

/**
 * UserEndpoint
 *
 * @author liuruichao
 * Created on 2018/6/4 18:26
 */
@ApplicationScoped
@DeclareRoles({"ViewBalance", "Debtor", "Creditor", "Debtor2", "BigSpender"})
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserEndpoint {
    @Inject
    private JsonWebToken jsonWebToken;

    /*@GET
    public String login(@QueryParam("username") String username, @QueryParam("password") String password) throws Exception {
        if (username.equals("liuruichao") && password.equals("liuruichao123")) {

            String token = TokenUtils.generateTokenString("/token1.json");
            System.out.println(token);
            return "success";
        }
        return "fail";
    }*/

    @POST
    @RolesAllowed({"ViewBalance"})
    public String getBalance() {
        System.out.println(jsonWebToken.getRawToken());
        return "100";
    }

    @Path("/name")
    @GET
    @RolesAllowed({"Creditor"})
    public Response getGroupd() {
        return Response.ok(jsonWebToken.getGroups()).build();
    }

    /*@GET
    @Path("/debit")
    @RolesAllowed({"Debtor", "Debtor2"})
    public String debit(@QueryParam("amount") String amount,
                          @Context SecurityContext securityContext) {
        Double damount = Double.valueOf(amount);
        if(damount > bigSpenderLimit) {
            if(securityContext.isUserInRole("BigSpender")) {
                // Validate the spending limit from the token claim
                JsonNumber spendingLimit = jwt.getClaim("spendingLimit");
                if(spendingLimit == null || spendingLimit.doubleValue() < damount) {
                    return Response.status(Response.Status.BAD_REQUEST).build();
                }
            } else {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        }
        usdBalance = usdBalance.subtract(new BigDecimal(amount));
        return Response.ok(generateBalanceInfo()).build();
    }*/
}
