package com.test.zhz.demo.BsTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/***
 *  方法的功能描述:Java网络编程 - 浅析web服务器与浏览器的实现原理
 *  http://blog.csdn.net/ghost_programmer/article/details/43446531
 *  @version :  V1.0.0
 *  @since   :  18/1/10 下午3:15
 *
 *  AUTHOR   :  zhz
**/
public class MyBrowser {

    public static void main(String[] args) {
        try {
            Socket browser = new Socket("localhost", 9090);
            PrintWriter pw = new PrintWriter(browser.getOutputStream(),true);
            // 封装请求第一行
            pw.println("GET/ HTTP/1.1");
            // 封装请求头
            pw.println("User-Agent: Java/1.6.0_13");
            pw.println("Host: locahost:9090");
            pw.println("Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2");
            pw.println("Connection: keep-alive");
            // 空行
            pw.println();
            // 封装实体主体
            pw.println("UserName=zhangsan&Age=17");
            // 写入完毕
            browser.shutdownOutput();

            // 接受服务器返回信息，
            InputStream in = browser.getInputStream();
            //
            int length = 0;
            StringBuffer request = new StringBuffer();
            byte[] buf = new byte[1024];
            //
            while ((length = in.read(buf)) != -1) {
                String line = new String(buf, 0, length);
                request.append(line);
            }
            System.out.println(request);
            //browser.close();
        } catch (IOException e) {
            System.out.println("异常了，操!");
        }finally{

        }
    }
}
