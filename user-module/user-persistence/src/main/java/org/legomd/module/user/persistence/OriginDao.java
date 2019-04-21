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
public interface OriginDao extends Service {
    @Fluent
    OriginDao register(JsonObject user, Handler<AsyncResult<String>> resultHandler);

    @Fluent
    OriginDao login(String loginName, String pwd, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    OriginDao changePwd(long userId, String pwd, long versions, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    OriginDao getMemberById(long userId, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    OriginDao activateEmailUser(long userId, long versions, Handler<AsyncResult<Integer>> resultHandler);

    @Fluent
    OriginDao findEmailUser(String loginName, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    OriginDao getUserInfo(long userId, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    OriginDao updateEmail(long userId, String email, long versions, Handler<AsyncResult<Integer>> handler);

    @Fluent
    OriginDao updateIdcard(long userId, String realName, String idCard, String idCardPositive, String idCardNegative, Handler<AsyncResult<Integer>> handler);

    @Fluent
    OriginDao getIdcardInfo(long userId, Handler<AsyncResult<JsonObject>> handler);

    @Fluent
    OriginDao getBindMobile(long userId, Handler<AsyncResult<JsonObject>> handler);

    @Fluent
    OriginDao bindMobile(long userId, String mobile, String code, Handler<AsyncResult<Integer>> handler);
}
