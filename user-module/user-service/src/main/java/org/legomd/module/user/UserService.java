package org.legomd.module.user;

import io.vertx.reactivex.core.AbstractVerticle;
import org.legomd.framework.core.ServiceProxy;
import org.legomd.module.core.persistence.DB;
import org.legomd.module.core.persistence.DatabaseMgr;
import org.legomd.module.user.handler.UserHandler;
import org.legomd.module.user.persistence.UserDao;
import org.legomd.module.user.persistence.impl.UserDaoImpl;
import org.legomd.module.user.service.UserHandlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Quinn
 * @Date: 2018/12/4 12:19
 * @Description:
 */
public class UserService extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Override
    public void start() throws Exception {
        super.start();
        LOGGER.info("User Service Pub");
    }

    public static void init(boolean pub) {
        DatabaseMgr.init(DB.LEGOMD_DOC);
        ServiceProxy.register(UserDao.class, new UserDaoImpl());
        ServiceProxy.register(UserHandler.class, new UserHandlerImpl(), pub);
    }

}