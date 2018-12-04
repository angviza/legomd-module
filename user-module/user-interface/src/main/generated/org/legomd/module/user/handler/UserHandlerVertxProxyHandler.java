/*
* Copyright 2014 Red Hat, Inc.
*
* Red Hat licenses this file to you under the Apache License, version 2.0
* (the "License"); you may not use this file except in compliance with the
* License. You may obtain a copy of the License at:
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations
* under the License.
*/

package org.legomd.module.user.handler;

import org.legomd.module.user.handler.UserHandler;
import io.vertx.core.Vertx;
import io.vertx.core.Handler;
import io.vertx.core.AsyncResult;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.ReplyException;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import io.vertx.serviceproxy.ProxyHelper;
import io.vertx.serviceproxy.ProxyHandler;
import io.vertx.serviceproxy.ServiceException;
import io.vertx.serviceproxy.ServiceExceptionMessageCodec;
import io.vertx.serviceproxy.HelperUtils;

import org.legomd.module.user.handler.UserHandler;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import org.legomd.framework.core.Service;
/*
  Generated Proxy code - DO NOT EDIT
  @author Roger the Robot
*/

@SuppressWarnings({"unchecked", "rawtypes"})
public class UserHandlerVertxProxyHandler extends ProxyHandler {

  public static final long DEFAULT_CONNECTION_TIMEOUT = 5 * 60; // 5 minutes 
  private final Vertx vertx;
  private final UserHandler service;
  private final long timerID;
  private long lastAccessed;
  private final long timeoutSeconds;

  public UserHandlerVertxProxyHandler(Vertx vertx, UserHandler service){
    this(vertx, service, DEFAULT_CONNECTION_TIMEOUT);
  }

  public UserHandlerVertxProxyHandler(Vertx vertx, UserHandler service, long timeoutInSecond){
    this(vertx, service, true, timeoutInSecond);
  }

  public UserHandlerVertxProxyHandler(Vertx vertx, UserHandler service, boolean topLevel, long timeoutSeconds) {
      this.vertx = vertx;
      this.service = service;
      this.timeoutSeconds = timeoutSeconds;
      try {
        this.vertx.eventBus().registerDefaultCodec(ServiceException.class,
            new ServiceExceptionMessageCodec());
      } catch (IllegalStateException ex) {}
      if (timeoutSeconds != -1 && !topLevel) {
        long period = timeoutSeconds * 1000 / 2;
        if (period > 10000) {
          period = 10000;
        }
        this.timerID = vertx.setPeriodic(period, this::checkTimedOut);
      } else {
        this.timerID = -1;
      }
      accessed();
    }


  private void checkTimedOut(long id) {
    long now = System.nanoTime();
    if (now - lastAccessed > timeoutSeconds * 1000000000) {
      close();
    }
  }

    @Override
    public void close() {
      if (timerID != -1) {
        vertx.cancelTimer(timerID);
      }
      super.close();
    }

    private void accessed() {
      this.lastAccessed = System.nanoTime();
    }

  public void handle(Message<JsonObject> msg) {
    try{
      JsonObject json = msg.body();
      String action = msg.headers().get("action");
      if (action == null) throw new IllegalStateException("action not specified");
      accessed();
      switch (action) {
        case "register": {
          service.register((io.vertx.core.json.JsonObject)json.getValue("user"),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "login": {
          service.login((java.lang.String)json.getValue("loginName"),
                        (java.lang.String)json.getValue("pwd"),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "changePwd": {
          service.changePwd(json.getValue("userId") == null ? null : (json.getLong("userId").longValue()),
                        (java.lang.String)json.getValue("pwd"),
                        json.getValue("versions") == null ? null : (json.getLong("versions").longValue()),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "getMemberById": {
          service.getMemberById(json.getValue("userId") == null ? null : (json.getLong("userId").longValue()),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "activateEmailUser": {
          service.activateEmailUser(json.getValue("userId") == null ? null : (json.getLong("userId").longValue()),
                        json.getValue("versions") == null ? null : (json.getLong("versions").longValue()),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "findEmailUser": {
          service.findEmailUser((java.lang.String)json.getValue("loginName"),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "getUserInfo": {
          service.getUserInfo(json.getValue("userId") == null ? null : (json.getLong("userId").longValue()),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "updateEmail": {
          service.updateEmail(json.getValue("userId") == null ? null : (json.getLong("userId").longValue()),
                        (java.lang.String)json.getValue("email"),
                        json.getValue("versions") == null ? null : (json.getLong("versions").longValue()),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "updateIdcard": {
          service.updateIdcard(json.getValue("userId") == null ? null : (json.getLong("userId").longValue()),
                        (java.lang.String)json.getValue("realName"),
                        (java.lang.String)json.getValue("idCard"),
                        (java.lang.String)json.getValue("idCardPositive"),
                        (java.lang.String)json.getValue("idCardNegative"),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "getIdcardInfo": {
          service.getIdcardInfo(json.getValue("userId") == null ? null : (json.getLong("userId").longValue()),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "getBindMobile": {
          service.getBindMobile(json.getValue("userId") == null ? null : (json.getLong("userId").longValue()),
                        HelperUtils.createHandler(msg));
          break;
        }
        case "bindMobile": {
          service.bindMobile(json.getValue("userId") == null ? null : (json.getLong("userId").longValue()),
                        (java.lang.String)json.getValue("mobile"),
                        (java.lang.String)json.getValue("code"),
                        HelperUtils.createHandler(msg));
          break;
        }
        default: throw new IllegalStateException("Invalid action: " + action);
      }
    } catch (Throwable t) {
      msg.reply(new ServiceException(500, t.getMessage()));
      throw t;
    }
  }
}