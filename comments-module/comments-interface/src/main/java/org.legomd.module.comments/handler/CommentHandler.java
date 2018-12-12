package org.legomd.module.comments.handler;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import org.legomd.framework.core.Service;

/**
 * @Author: maru
 * @Date: 2018-12-13
 * @Description:
 */
@VertxGen
@ProxyGen
public interface CommentHandler extends Service {
    @Fluent
    CommentHandler comment(String replyCommentID, String commenterID, String comment, Handler<AsyncResult<String>> resultHandler);

    @Fluent
    CommentHandler like(String replyCommentID, Handler<AsyncResult<String>> resultHandler);

    @Fluent
    CommentHandler unlike(String replyCommentID, Handler<AsyncResult<String>> resultHandler);

    @Fluent
    CommentHandler getCommentByCommentID(String commentID, Handler<AsyncResult<JsonObject>> resultHandler);

    @Fluent
    CommentHandler getCommentListByCommenterID(String commenterID, Handler<AsyncResult<JsonObject>> resultHandler);
}
