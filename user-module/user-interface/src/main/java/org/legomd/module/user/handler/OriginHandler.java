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
public interface OriginHandler extends Service {
    @Fluent
    OriginHandler register(JsonObject user, Handler<AsyncResult<String>> resultHandler);

    @Fluent
    OriginHandler login(String loginName, String pwd, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    OriginHandler changePwd(long userId, String pwd, long versions, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    OriginHandler getMemberById(long userId, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    OriginHandler activateEmailUser(long userId, long versions, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    OriginHandler findEmailUser(String loginName, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    OriginHandler getUserInfo(long userId, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    OriginHandler updateEmail(long userId, String email, long versions, Handler<AsyncResult<Integer>> handler);

    @Fluent
    OriginHandler updateIdcard(long userId, String realName, String idCard, String idCardPositive, String idCardNegative, Handler<AsyncResult<Integer>> handler);

    @Fluent
    OriginHandler getIdcardInfo(long userId, Handler<AsyncResult<JsonObject>> handler);

    @Fluent
    OriginHandler getBindMobile(long userId, Handler<AsyncResult<JsonObject>> handler);

    @Fluent
    OriginHandler bindMobile(long userId, String mobile, String code, Handler<AsyncResult<Integer>> handler);
}
