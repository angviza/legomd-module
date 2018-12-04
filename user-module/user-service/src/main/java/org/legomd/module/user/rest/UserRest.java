package org.legomd.module.user.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.vertx.core.json.JsonObject;
import org.legomd.framework.core.ServiceProxy;
import org.legomd.framework.web.result.Result;
import org.legomd.framework.web.result.ResultItem;
import org.legomd.module.user.handler.UserHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * @Author: Quinn
 * @Date: 2018/12/4 12:19
 * @Description:
 */
@Path("user")
@Api(value = "用户controller", tags = {"用户操作接口"})
@Produces({MediaType.APPLICATION_JSON})
public class UserRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRest.class);
    UserHandler userHandler;

    public UserRest() {
        userHandler = ServiceProxy.getAs(UserHandler.class);
    }
    @POST
    @Path("test")
    @ApiOperation(value = "获取用户信息", notes = "注意问题点")
    @Produces({MediaType.APPLICATION_JSON})
    public void test(@QueryParam("name") String uname, @QueryParam("pwd") String pwd, @Suspended final AsyncResponse asyncResponse) {
        JsonObject user = new JsonObject();
        user.put("userName", uname).put("loginName", uname).put("password", pwd);
        LOGGER.info("{}", user);
        ResultItem rd = new ResultItem();
        rd.setData(Arrays.asList(user, user));
        asyncResponse.resume(Response.status(Response.Status.OK).entity(rd).build());


    }

    @POST
    @ApiOperation(value = "获取用户信息1", notes = "注意问题点1")
    @Produces({MediaType.APPLICATION_JSON})
    public void hello(@QueryParam("name") String uname, @QueryParam("pwd") String pwd, @Suspended final AsyncResponse asyncResponse) {
        JsonObject user = new JsonObject();
        user.put("userName", uname).put("loginName", uname).put("password", pwd);
        LOGGER.info("{}", user);
        userHandler.register(user, rh -> {
            if (rh.succeeded()) {
                LOGGER.info("{}", rh.result());
                asyncResponse.resume(Response.status(Response.Status.OK).entity(new Result(true, Result.ResultCode.E101,rh.result() + ":========")).build());
            } else {
                LOGGER.error("{}", rh.cause());
            }

        });
    }
}


