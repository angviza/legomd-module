package org.legomd.module.user.persistence;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import org.legomd.framework.core.Service;

@VertxGen
@ProxyGen
public interface UserDao extends Service {
    @Fluent
    UserDao register(JsonObject user, Handler<AsyncResult<String>> resultHandler);

    @Fluent
    UserDao login(String loginName, String pwd, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    UserDao changePwd(long userId, String pwd, long versions, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    UserDao getMemberById(long userId, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    UserDao activateEmailUser(long userId, long versions, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    UserDao findEmailUser(String loginName, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    UserDao getUserInfo(long userId, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    UserDao updateEmail(long userId, String email, long versions, Handler<AsyncResult<Integer>> handler);

    @Fluent
    UserDao updateIdcard(long userId, String realName, String idCard, String idCardPositive, String idCardNegative, Handler<AsyncResult<Integer>> handler);

    @Fluent
    UserDao getIdcardInfo(long userId, Handler<AsyncResult<JsonObject>> handler);

    @Fluent
    UserDao getBindMobile(long userId, Handler<AsyncResult<JsonObject>> handler);

    @Fluent
    UserDao bindMobile(long userId, String mobile, String code, Handler<AsyncResult<Integer>> handler);
}
