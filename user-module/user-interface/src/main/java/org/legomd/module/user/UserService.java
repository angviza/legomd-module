package org.legomd.module.user;

import org.legomd.framework.core.ServiceProxy;
import org.legomd.module.user.handler.UserHandler;

/**
 * @Author: Quinn
 * @Date: 2018/12/4 12:19
 * @Description:
 */
public class UserService {
    public static void init(){
        ServiceProxy.register(UserHandler.class);
    }
}
