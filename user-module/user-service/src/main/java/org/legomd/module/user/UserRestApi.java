package org.legomd.module.user;


import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.auth.AuthProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.legomd.framework.web.core.RestServer;

public class UserRestApi extends RestServer {
    protected String configFile = "/tmp/webconfig2.json";
    private static final Logger LOGGER = LogManager.getLogger(UserRestApi.class);

    public static UserRestApi create(Vertx vertx) {
        return new UserRestApi(vertx);
    }

    public UserRestApi(Vertx vertx) {
        super(vertx);
    }

    @Override
    protected AuthProvider setupAuthenticationRoutes() {
        return super.setupAuthenticationRoutes();
    }
}