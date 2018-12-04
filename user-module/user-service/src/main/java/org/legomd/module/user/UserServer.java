package org.legomd.module.user;


import org.legomd.framework.core.VertxRxApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Quinn
 * @Email angviza@gmail.com
 * @Date 2018/12/4 12:19
 */
public class UserServer extends VertxRxApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServer.class);


    public static void main(String[] args) {
        VertxRxApplication.create().start().subscribe(vertx -> {
            UserService.init(true);//true 发布远程服务 / false 仅本地启动
            //启动Restfull Api Http Server
            //vertx.deployVerticle(UserService.class.getName());
//            JsonObject webconf= AppContext.get().getConfig().get("web");
//            UserRestApi.create(vertx).start(webconf, UserRest.class).subscribe(() -> System.err.println("RestServer started"),
//                    x -> x.printStackTrace());
        }, e -> {
            LOGGER.error("{}", e);
        });

    }
}
