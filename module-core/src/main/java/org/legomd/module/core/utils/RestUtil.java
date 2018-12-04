package org.legomd.module.core.utils;

/**
 * @Author: Quinn
 * @Date: 2018/12/5 17:00
 * @Description:
 */
public class RestUtil {
    public static final String API_PATH = "/api/";
    public static final String API_V1_PATH = API_PATH + "v1/";

    public static String apiv1(String path) {
        return API_V1_PATH + path;
    }
}
