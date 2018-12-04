package org.legomd.module.user.service;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import org.legomd.framework.core.ServiceProxy;
import org.legomd.module.user.handler.UserHandler;
import org.legomd.module.user.persistence.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserHandlerImpl implements UserHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserHandlerImpl.class);
    UserDao dao;

    public UserHandlerImpl() {
       dao = ServiceProxy.getAs(UserDao.class);
    }

    @Override
    public UserHandler register(JsonObject user, Handler<AsyncResult<String>> resultHandler) {
        //User.create(IdBuilder.getUniqueId(), loginName, mobile, email, pwd, salt, resultHandler);
        dao.register(user,resultHandler);
        return this;
    }

    @Override
    public UserHandler login(String loginName, String pwd, Handler<AsyncResult<JsonObject>> resultHandler) {
        LOGGER.info("login:{},{}",loginName,pwd);
        dao.login(loginName, pwd, resultHandler);
        return this;
    }

    @Override
    public UserHandler changePwd(long userId, String pwd, long versions, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public UserHandler getMemberById(long userId, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public UserHandler activateEmailUser(long userId, long versions, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public UserHandler findEmailUser(String loginName, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public UserHandler getUserInfo(long userId, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public UserHandler updateEmail(long userId, String email, long versions, Handler<AsyncResult<Integer>> handler) {
        return null;
    }

    @Override
    public UserHandler updateIdcard(long userId, String realName, String idCard, String idCardPositive, String idCardNegative, Handler<AsyncResult<Integer>> handler) {
        return null;
    }

    @Override
    public UserHandler getIdcardInfo(long userId, Handler<AsyncResult<JsonObject>> handler) {
        return null;
    }

    @Override
    public UserHandler getBindMobile(long userId, Handler<AsyncResult<JsonObject>> handler) {
        return null;
    }

    @Override
    public UserHandler bindMobile(long userId, String mobile, String code, Handler<AsyncResult<Integer>> handler) {
        return null;
    }
}
