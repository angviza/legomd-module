/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.legomd.module.user.persistence.rxjava;

import java.util.Map;
import rx.Observable;
import rx.Single;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import org.legomd.framework.core.Service;


@io.vertx.lang.rx.RxGen(org.legomd.module.user.persistence.UserDao.class)
public class UserDao {

  @Override
  public String toString() {
    return delegate.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserDao that = (UserDao) o;
    return delegate.equals(that.delegate);
  }
  
  @Override
  public int hashCode() {
    return delegate.hashCode();
  }

  public static final io.vertx.lang.rx.TypeArg<UserDao> __TYPE_ARG = new io.vertx.lang.rx.TypeArg<>(    obj -> new UserDao((org.legomd.module.user.persistence.UserDao) obj),
    UserDao::getDelegate
  );

  private final org.legomd.module.user.persistence.UserDao delegate;
  
  public UserDao(org.legomd.module.user.persistence.UserDao delegate) {
    this.delegate = delegate;
  }

  public org.legomd.module.user.persistence.UserDao getDelegate() {
    return delegate;
  }

  public org.legomd.module.user.persistence.rxjava.UserDao register(JsonObject user, Handler<AsyncResult<String>> resultHandler) { 
    delegate.register(user, resultHandler);
    return this;
  }

    public Single<String> rxRegister(JsonObject user) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      register(user, fut);
    }));
  }

  public org.legomd.module.user.persistence.rxjava.UserDao login(String loginName, String pwd, Handler<AsyncResult<JsonObject>> resultHandler) { 
    delegate.login(loginName, pwd, resultHandler);
    return this;
  }

    public Single<JsonObject> rxLogin(String loginName, String pwd) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      login(loginName, pwd, fut);
    }));
  }

  public org.legomd.module.user.persistence.rxjava.UserDao changePwd(long userId, String pwd, long versions, Handler<AsyncResult<Integer>> resultHandler) { 
    delegate.changePwd(userId, pwd, versions, resultHandler);
    return this;
  }

    public Single<Integer> rxChangePwd(long userId, String pwd, long versions) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      changePwd(userId, pwd, versions, fut);
    }));
  }

  public org.legomd.module.user.persistence.rxjava.UserDao getMemberById(long userId, Handler<AsyncResult<JsonObject>> resultHandler) { 
    delegate.getMemberById(userId, resultHandler);
    return this;
  }

    public Single<JsonObject> rxGetMemberById(long userId) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      getMemberById(userId, fut);
    }));
  }

  public org.legomd.module.user.persistence.rxjava.UserDao activateEmailUser(long userId, long versions, Handler<AsyncResult<Integer>> resultHandler) { 
    delegate.activateEmailUser(userId, versions, resultHandler);
    return this;
  }

    public Single<Integer> rxActivateEmailUser(long userId, long versions) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      activateEmailUser(userId, versions, fut);
    }));
  }

  public org.legomd.module.user.persistence.rxjava.UserDao findEmailUser(String loginName, Handler<AsyncResult<JsonObject>> resultHandler) { 
    delegate.findEmailUser(loginName, resultHandler);
    return this;
  }

    public Single<JsonObject> rxFindEmailUser(String loginName) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      findEmailUser(loginName, fut);
    }));
  }

  public org.legomd.module.user.persistence.rxjava.UserDao getUserInfo(long userId, Handler<AsyncResult<JsonObject>> resultHandler) { 
    delegate.getUserInfo(userId, resultHandler);
    return this;
  }

    public Single<JsonObject> rxGetUserInfo(long userId) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      getUserInfo(userId, fut);
    }));
  }

  public org.legomd.module.user.persistence.rxjava.UserDao updateEmail(long userId, String email, long versions, Handler<AsyncResult<Integer>> handler) { 
    delegate.updateEmail(userId, email, versions, handler);
    return this;
  }

    public Single<Integer> rxUpdateEmail(long userId, String email, long versions) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      updateEmail(userId, email, versions, fut);
    }));
  }

  public org.legomd.module.user.persistence.rxjava.UserDao updateIdcard(long userId, String realName, String idCard, String idCardPositive, String idCardNegative, Handler<AsyncResult<Integer>> handler) { 
    delegate.updateIdcard(userId, realName, idCard, idCardPositive, idCardNegative, handler);
    return this;
  }

    public Single<Integer> rxUpdateIdcard(long userId, String realName, String idCard, String idCardPositive, String idCardNegative) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      updateIdcard(userId, realName, idCard, idCardPositive, idCardNegative, fut);
    }));
  }

  public org.legomd.module.user.persistence.rxjava.UserDao getIdcardInfo(long userId, Handler<AsyncResult<JsonObject>> handler) { 
    delegate.getIdcardInfo(userId, handler);
    return this;
  }

    public Single<JsonObject> rxGetIdcardInfo(long userId) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      getIdcardInfo(userId, fut);
    }));
  }

  public org.legomd.module.user.persistence.rxjava.UserDao getBindMobile(long userId, Handler<AsyncResult<JsonObject>> handler) { 
    delegate.getBindMobile(userId, handler);
    return this;
  }

    public Single<JsonObject> rxGetBindMobile(long userId) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      getBindMobile(userId, fut);
    }));
  }

  public org.legomd.module.user.persistence.rxjava.UserDao bindMobile(long userId, String mobile, String code, Handler<AsyncResult<Integer>> handler) { 
    delegate.bindMobile(userId, mobile, code, handler);
    return this;
  }

    public Single<Integer> rxBindMobile(long userId, String mobile, String code) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      bindMobile(userId, mobile, code, fut);
    }));
  }


  public static  UserDao newInstance(org.legomd.module.user.persistence.UserDao arg) {
    return arg != null ? new UserDao(arg) : null;
  }
}
