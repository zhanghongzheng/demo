package com.test.zhz.demo.BsTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/**
 * Created by zhz on 18/1/10.
 */
public class MyBrowserUrl {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:9090");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            InputStream in = conn.getInputStream();
            byte[] buf = new byte[1024];
            int length = 0;
            StringBuffer text = new StringBuffer();
            String line = null;
            while ((length = in.read(buf)) != -1) {
                line = new String(buf, 0, length);
                text.append(line);
            }

            System.out.println(text);
        } catch (IOException e) {
            System.out.println("异常了，操!");
        }finally{

        }
    }
}
