package com.zw.dao;

import com.zw.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {
    @Select("select * from t_user where id = #{id}")
    public User getById(Integer id);

    @Insert("insert into t_user(name,age,sex)values(#{name},#{age},#{sex})")
    public int addUser(User user);

    @Update("update t_user set name=#{name},age=#{age},sex=#{sex} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from t_user where id=#{id}")
    int deleteUser(@Param("id") int id);
}
