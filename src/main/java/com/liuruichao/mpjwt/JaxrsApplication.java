package com.liuruichao.mpjwt;

import org.eclipse.microprofile.auth.LoginConfig;
import org.springframework.stereotype.Component;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * MyApplication
 *
 * @author liuruichao
 * Created on 2018/6/4 17:41
 */
@LoginConfig(authMethod = "MP-JWT", realmName = "jwt-jaspi")
@ApplicationScoped
@Component
@ApplicationPath("/v1")
public class JaxrsApplication extends Application {

}
