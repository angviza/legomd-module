package org.legomd.module.user.persistence.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.sql.UpdateResult;
import org.legomd.framework.persistence.mongo.MongoEntityAccesser;
import org.legomd.module.core.persistence.DB;
import org.legomd.module.core.persistence.DatabaseMgr;
import org.legomd.module.user.model.User;
import org.legomd.module.user.persistence.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl extends MongoEntityAccesser implements UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    public UserDaoImpl() {
        super(DatabaseMgr.getAs(DB.LEGOMD_DOC), User.class);
    }

    @Override
    public UserDao register(JsonObject user, Handler<AsyncResult<String>> resultHandler) {
        save(user, resultHandler);
        return this;
    }

    @Override
    public UserDao login(String loginName, String pwd, Handler<AsyncResult<JsonObject>> resultHandler) {
        this.findOne(new JsonObject().put("userName", loginName), null, resultHandler);
        return this;
    }

//    private <T> void setF(Single single, Handler<AsyncResult<T>> resultHandler) {
//        Future future = Future.future();
//        LOGGER.info("==single:{}===future=={}",single,future);
//
//        single.subscribe(o->{
//            future.complete(o);
//            LOGGER.info("====o==={}",o);
//        }, e -> {
//            LOGGER.error("====e==={}",e);
//            future.fail(e);
//        });
//        LOGGER.info("resultHandler:{}",resultHandler);
//        resultHandler.handle(future);
//    }

    @Override
    public UserDao changePwd(long userId, String pwd, long versions, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public UserDao getMemberById(long userId, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public UserDao activateEmailUser(long userId, long versions, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public UserDao findEmailUser(String loginName, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public UserDao getUserInfo(long userId, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    public UserDao saveUserInfo(long userId, String loginName, String userName, String mobile, String email, int sex, long birthday, String photoUrl, Handler<AsyncResult<UpdateResult>> resultHandler) {
        return null;
    }


    @Override
    public UserDao updateEmail(long userId, String email, long versions, Handler<AsyncResult<Integer>> handler) {
        return null;
    }

    @Override
    public UserDao updateIdcard(long userId, String realName, String idCard, String idCardPositive, String idCardNegative, Handler<AsyncResult<Integer>> handler) {
        return null;
    }

    @Override
    public UserDao getIdcardInfo(long userId, Handler<AsyncResult<JsonObject>> handler) {
        return null;
    }

    @Override
    public UserDao getBindMobile(long userId, Handler<AsyncResult<JsonObject>> handler) {
        return null;
    }

    @Override
    public UserDao bindMobile(long userId, String mobile, String code, Handler<AsyncResult<Integer>> handler) {
        return null;
    }
}
