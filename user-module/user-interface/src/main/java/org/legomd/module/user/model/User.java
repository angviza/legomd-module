package org.legomd.module.user.model;

import io.vertx.core.json.JsonObject;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Quinn
 * @Date: 2018/12/4 12:19
 * @Description:
 */
public class User implements Serializable {
    private long userId;

    public static JsonObject create(long userId, String userName, String loginName, String password) {
        return new JsonObject().put("userId", userId).put("userName", userName).put("loginName", loginName).put("password", password);
    }

    public User(long userId, String userName, String loginName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.loginName = loginName;
        this.password = password;
    }

    public User(long userId, String jack, String loginName, String pwd, int i, int i1, String srsaf, String wae123123, Date date, Date date1, String s, int i2) {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String userName;
    private String loginName;
    private String password;

    public User() {
    }

}
