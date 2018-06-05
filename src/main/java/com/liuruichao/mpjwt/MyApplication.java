package com.liuruichao.mpjwt;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * MyApplication
 *
 * @author liuruichao
 * Created on 2018/6/4 18:21
 */
@LoginConfig(authMethod = "MP-JWT", realmName = "jwt-jaspi")
@ApplicationScoped
@ApplicationPath("/v1")
public class MyApplication extends Application {
}
