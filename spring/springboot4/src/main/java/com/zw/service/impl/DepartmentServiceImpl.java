package com.zw.service.impl;

import com.zw.dao.DepartmentDao;
import com.zw.domain.Department;
import com.zw.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public int save(Department department) {
       return departmentDao.save(department);
    }
}
