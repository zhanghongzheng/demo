package com.test.zhz.demo.pool;/**
 * Created by zhz on 18/6/8.
 */

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 功能:
 *
 * @author zhz
 * @date 18/6/8 下午4:55
 */
public class SocketFactory extends BasePooledObjectFactory<Socket> {
    private InetSocketAddress address;

    public SocketFactory(String ip, int port) {
        this.address = new InetSocketAddress(ip, port);
    }

    @Override
    public Socket create() throws Exception {
        Socket socket = new Socket();
        socket.connect(address);
        return socket;
    }

    @Override
    public PooledObject<Socket> wrap(Socket obj) {
        return new DefaultPooledObject<Socket>(obj);
    }

    @Override
    public void destroyObject(PooledObject<Socket> p) {
        try {
            if (p != null && p.getObject() != null) {
                p.getObject().close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateObject(PooledObject<Socket> p) {
        if (p == null) {
            return false;
        }
        Socket socket = p.getObject();
        if (socket == null) {
            return false;
        }
        if (!socket.isConnected() || socket.isClosed()) {
            return false;
        }
        return true;
    }
}
