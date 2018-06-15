package com.test.zhz.demo.pool;/**
 * Created by zhz on 18/6/8.
 */

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * 功能:
 *
 * @author zhz
 * @date 18/6/8 下午6:49
 */
public class SocketConfigWrap extends GenericObjectPoolConfig {
    private int pool_max_size;

    public int getPool_max_size() {
        return super.getMaxTotal();
    }

    public void setPool_max_size(int pool_max_size) {
        super.setMaxTotal(pool_max_size);
    }

    public SocketConfigWrap(int pool_max_size) {
        this.pool_max_size = pool_max_size;
    }
}
