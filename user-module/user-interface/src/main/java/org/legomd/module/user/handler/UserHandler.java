package org.legomd.module.user.handler;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import org.legomd.framework.core.Service;

@VertxGen
@ProxyGen
public interface UserHandler extends Service {
    @Fluent
    UserHandler register(JsonObject user, Handler<AsyncResult<String>> resultHandler);

    @Fluent
    UserHandler login(String loginName, String pwd, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    UserHandler changePwd(long userId, String pwd, long versions, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    UserHandler getMemberById(long userId, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    UserHandler activateEmailUser(long userId, long versions, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    UserHandler findEmailUser(String loginName, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    UserHandler getUserInfo(long userId, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    UserHandler updateEmail(long userId, String email, long versions, Handler<AsyncResult<Integer>> handler);

    @Fluent
    UserHandler updateIdcard(long userId, String realName, String idCard, String idCardPositive, String idCardNegative, Handler<AsyncResult<Integer>> handler);

    @Fluent
    UserHandler getIdcardInfo(long userId, Handler<AsyncResult<JsonObject>> handler);

    @Fluent
    UserHandler getBindMobile(long userId, Handler<AsyncResult<JsonObject>> handler);

    @Fluent
    UserHandler bindMobile(long userId, String mobile, String code, Handler<AsyncResult<Integer>> handler);
}
