package com.test.zhz.demo.DeepJavaWeb.two;/**
 * Created by zhz on 18/5/23.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能:
 *
 * @author zhz
 * @date 18/5/23 下午4:35
 */
public class io_test {

    public static void test1_reader() throws Exception{
        StringBuffer sb = new StringBuffer();
        char[] buf = new char[1024];
        FileInputStream fis = new FileInputStream("file");
        FileReader fr = new FileReader("/tmp/test/test1.t");
        while (fr.read(buf)>0){
            sb.append(buf);
        }
        System.out.println(sb.toString());
        //writer
        FileWriter fw = new FileWriter("/tmp/test/test2.t");
        fw.write("adfsfsd");
    }

    public static void test2_socket() throws Exception{
        Socket client = new Socket("localhost",8081);
        InputStreamReader sr= new InputStreamReader(client.getInputStream());

    }

    public static void test3_socketServer() throws Exception{
        ServerSocket serverSocket = new ServerSocket(8081);

    }

    public static void main(String[] args) throws Exception{
        test1_reader();
    }
}
