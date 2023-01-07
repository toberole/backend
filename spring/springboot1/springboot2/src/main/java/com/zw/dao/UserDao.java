package com.zw.dao;

import com.zw.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from test where id = #{id}")
    User getById(Integer id);
}
