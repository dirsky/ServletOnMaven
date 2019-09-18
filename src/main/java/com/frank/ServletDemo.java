package com.frank;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


/**
 * @author Gozhong Xu
 */
public class ServletDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("this is s");
        String str = "";

        // 设置Http连接的Url,创建连接
        URL url = new URL("http://localhost:8080/js");
        //打开链接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置输入输出
        conn.setDoOutput(true);
        conn.setDoInput(true);
        //设置传递方式
        conn.setRequestMethod("GET");
        //设置接收参数的类型
        conn.setRequestProperty("Accept", "application/json");
        //设置请求参数的类型
        conn.setRequestProperty("Content-Type", "application/json");
        //创建连接
        conn.connect();
        //向url发送数据
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(conn.getOutputStream());
        bufferedOutputStream.write(str.getBytes());
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        //接收响应的数据
        BufferedInputStream bufferedInputStream = new BufferedInputStream(conn.getInputStream());
        byte[] b = new byte[bufferedInputStream.available()];
        bufferedInputStream.read(b);
        bufferedInputStream.close();
        String buff = new String(b);

//        JSONObject jsonObject = JSONObject.quote(buff);

        System.out.println(buff);


//        request.getRequestDispatcher("/hello.jsp").forward(request,response);
    }
}
