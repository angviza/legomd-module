package org.legomd.module.user.service;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import org.legomd.framework.core.ServiceProxy;
import org.legomd.framework.persistence.Dao;
import org.legomd.module.user.handler.OriginHandler;
import org.legomd.module.user.persistence.OriginDao;
import org.legomd.module.user.persistence.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OriginHandlerImpl implements OriginHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(OriginHandlerImpl.class);
    OriginDao dao;

    public OriginHandlerImpl() {
       dao = ServiceProxy.getAs(OriginDao.class);
    }

    @Override
    public OriginHandler register(JsonObject user, Handler<AsyncResult<String>> resultHandler) {
        //User.create(IdBuilder.getUniqueId(), loginName, mobile, email, pwd, salt, resultHandler);
        dao.register(user,resultHandler);
        return this;
    }

    @Override
    public OriginHandler login(String loginName, String pwd, Handler<AsyncResult<JsonObject>> resultHandler) {
        LOGGER.info("login:{},{}",loginName,pwd);
        dao.login(loginName, pwd, resultHandler);
        return this;
    }

    @Override
    public OriginHandler changePwd(long userId, String pwd, long versions, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public OriginHandler getMemberById(long userId, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public OriginHandler activateEmailUser(long userId, long versions, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public OriginHandler findEmailUser(String loginName, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public OriginHandler getUserInfo(long userId, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public OriginHandler updateEmail(long userId, String email, long versions, Handler<AsyncResult<Integer>> handler) {
        return null;
    }

    @Override
    public OriginHandler updateIdcard(long userId, String realName, String idCard, String idCardPositive, String idCardNegative, Handler<AsyncResult<Integer>> handler) {
        return null;
    }

    @Override
    public OriginHandler getIdcardInfo(long userId, Handler<AsyncResult<JsonObject>> handler) {
        return null;
    }

    @Override
    public OriginHandler getBindMobile(long userId, Handler<AsyncResult<JsonObject>> handler) {
        return null;
    }

    @Override
    public OriginHandler bindMobile(long userId, String mobile, String code, Handler<AsyncResult<Integer>> handler) {
        return null;
    }
}
