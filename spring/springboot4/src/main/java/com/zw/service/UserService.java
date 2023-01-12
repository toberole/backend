package com.zw.service;

import com.zw.domain.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    @Transactional// 开启事物 一般写在接口方法上
    public int saveUser(User user);

    public User getById(int id);

    int updateUser(User user);

    int deleteUser(int id);
}
