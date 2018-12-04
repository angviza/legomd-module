package org.legomd.module.user.service;

import org.legomd.framework.commons.id.IdWorker;

/**
 * @Author: Quinn
 * @Email angviza@gmail.com
 * @Date: 2018/12/4 12:19
 * @Description:
 */
public class IdBuilder {

    /**
     * 创建唯一生成器
     */
    private static final IdWorker ID_WORKER = new IdWorker(1, 1);

    /**
     * 获取唯一id
     *
     * @return
     */
    public static long getUniqueId() {
        return ID_WORKER.nextId();
    }
}
