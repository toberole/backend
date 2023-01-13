package com.zw.service;

import com.zw.domain.Department;
import org.springframework.transaction.annotation.Transactional;

public interface DepartmentService {
    @Transactional// 事物一般标记在service上，可以直接写在service类级别上，这样就对所有的方式添加事物
    public int save(Department department);
}
