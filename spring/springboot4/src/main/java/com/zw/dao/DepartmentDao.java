package com.zw.dao;

import com.zw.domain.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DepartmentDao {
    @Insert("insert into t_department(name)values(#{name})")
    public int save(Department department);

    // UPDATE Person SET FirstName = 'Fred' WHERE LastName = 'Wilson'
    @Update("update t_department set name=#{name} where id=#{id}")
    public void update(Department department);
}
