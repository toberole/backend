package com.zw;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class TestInit extends AbstractDispatcherServletInitializer {
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
