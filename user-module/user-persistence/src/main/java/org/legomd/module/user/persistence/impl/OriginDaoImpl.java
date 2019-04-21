package org.legomd.module.user.persistence.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.sql.UpdateResult;
import org.legomd.framework.persistence.jdbc.JdbcEntityAccesser;
import org.legomd.framework.persistence.mongo.MongoEntityAccesser;
import org.legomd.module.core.persistence.DB;
import org.legomd.module.core.persistence.DatabaseMgr;
import org.legomd.module.user.model.User;
import org.legomd.module.user.persistence.OriginDao;
import org.legomd.module.user.persistence.OriginDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OriginDaoImpl extends JdbcEntityAccesser implements OriginDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(OriginDaoImpl.class);
    private static final String SQL_ADD_NEW_BOOK = "INSERT INTO book VALUES ($1, $2, $3, $4,$5,$6)";
    private static final String SQL_FIND_BOOK_BY_ID = "SELECT * FROM user WHERE id = $1";
    private static final String SQL_UPSERT_BOOK_BY_ID = "INSERT INTO user VALUES($1, $2, $3, $4,$5,$6) " +
            "ON CONFLICT(id) DO UPDATE SET title = $2, category = $3, publication_date = $4";

    public OriginDaoImpl() {
        super(DatabaseMgr.getAs(DB.LEGOMD_PG));
    }

    @Override
    public OriginDao register(JsonObject user, Handler<AsyncResult<String>> resultHandler) {
        this.execute(SQL_ADD_NEW_BOOK, new JsonArray().add(0).add("jodie").add("202cb962ac59075b964b07152d234b70").add("jodie@pp.com")
                .add(0).add(0));
        //save(user, resultHandler);
        return this;
    }

    @Override
    public OriginDao login(String loginName, String pwd, Handler<AsyncResult<JsonObject>> resultHandler) {

        //this.retrieveOne(new JsonObject().put("userName", loginName), null, resultHandler);
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
    public OriginDao changePwd(long userId, String pwd, long versions, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public OriginDao getMemberById(long userId, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public OriginDao activateEmailUser(long userId, long versions, Handler<AsyncResult<Integer>> resultHandler) {
        return null;
    }

    @Override
    public OriginDao findEmailUser(String loginName, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    @Override
    public OriginDao getUserInfo(long userId, Handler<AsyncResult<JsonObject>> resultHandler) {
        return null;
    }

    public OriginDao saveUserInfo(long userId, String loginName, String userName, String mobile, String email, int sex, long birthday, String photoUrl, Handler<AsyncResult<UpdateResult>> resultHandler) {
        return null;
    }


    @Override
    public OriginDao updateEmail(long userId, String email, long versions, Handler<AsyncResult<Integer>> handler) {
        return null;
    }

    @Override
    public OriginDao updateIdcard(long userId, String realName, String idCard, String idCardPositive, String idCardNegative, Handler<AsyncResult<Integer>> handler) {
        return null;
    }

    @Override
    public OriginDao getIdcardInfo(long userId, Handler<AsyncResult<JsonObject>> handler) {
        return null;
    }

    @Override
    public OriginDao getBindMobile(long userId, Handler<AsyncResult<JsonObject>> handler) {
        return null;
    }

    @Override
    public OriginDao bindMobile(long userId, String mobile, String code, Handler<AsyncResult<Integer>> handler) {
        return null;
    }
}
