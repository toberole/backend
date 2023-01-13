package com.zw.controller;

import com.zw.dao.DepartmentDao;
import com.zw.domain.Department;
import com.zw.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departs")
    public ResponseResult save(@RequestBody Department department) {
        int res = departmentService.save(department);
        return new ResponseResult(res, "save res: " + res);
    }
}
