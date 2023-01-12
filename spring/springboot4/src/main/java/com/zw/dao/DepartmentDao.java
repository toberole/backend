package com.zw.dao;

import com.zw.domain.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentDao {
    @Insert("insert into t_department(name)values(#{name})")
    public void save(Department department);
}
