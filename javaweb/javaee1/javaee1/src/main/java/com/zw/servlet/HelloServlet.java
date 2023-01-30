package com.zw.servlet;

import java.io.*;
import java.util.Date;

import com.zw.bean.User;
import com.zw.dao.UserDao;
import com.zw.dao.impl.UserDaoImpl;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet", asyncSupported = true)
public class HelloServlet extends HttpServlet {
    private String message;

    private UserDao userDao;

    public void init() {
        message = "Hello World!";
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            //Thread.sleep(1000 * 10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("HelloServlet#doGet thread: " + Thread.currentThread());

        User user = new User();
        user.id = 1;
        user.age = 11;
        user.name = "Hello";
        userDao.add(user);

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}