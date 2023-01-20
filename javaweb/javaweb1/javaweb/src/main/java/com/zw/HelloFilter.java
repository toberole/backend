package com.zw;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter")
public class HelloFilter extends HttpFilter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init ......");
    }

    public void destroy() {
        System.out.println("destroy ......");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
