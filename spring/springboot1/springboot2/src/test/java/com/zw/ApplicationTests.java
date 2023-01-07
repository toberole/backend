package com.zw;

import com.zw.bean.User;
import com.zw.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testUserDao() {
        User user = userDao.getById(1);
        System.out.println(user);
    }

}
