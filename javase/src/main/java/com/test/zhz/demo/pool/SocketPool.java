package com.test.zhz.demo.pool;/**
 * Created by zhz on 18/6/8.
 */

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.net.Socket;

/**
 * 功能:
 *
 * @author zhz
 * @date 18/6/8 下午3:40
 */
public class SocketPool {
    private GenericObjectPool<Socket> pool;

    public SocketPool(GenericObjectPoolConfig config, PooledObjectFactory factory) {
        pool = new GenericObjectPool<Socket>(factory, config);
    }

    public Socket getSocket() {
        try {
            return pool.borrowObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void returnPool(Socket socket){
        pool.returnObject(socket);
    }

    public static void main(String[] args) {

        SocketFactory socketFactory = new SocketFactory("localhost",8082);
        SocketConfigWrap config = new SocketConfigWrap(5);
        SocketPool pool = new SocketPool(config,socketFactory);

        for (int i=0;i<9;i++){
            Socket socket = pool.getSocket();//默认最多8个,获取第9个时,如果没有returnPool的,阻塞等待其他线程释放socket到pool
            System.out.println("socket="+socket);
//            pool.returnPool(socket);
//            System.out.println("socket="+socket);

        }

        Socket socket = pool.getSocket();
        System.out.println("socket9="+socket);
    }

}
