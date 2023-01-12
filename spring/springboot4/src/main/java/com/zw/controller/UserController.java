package com.zw.controller;

import com.zw.domain.User;
import com.zw.service.DepartmentService;
import com.zw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable int id) {
        User user = userService.getById(id);
        System.out.println(user);
        return new ResponseResult(0, user);
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable int id) {
        int res = userService.deleteUser(id);
        System.out.println(res);
        return new ResponseResult(res, "delete res: " + res);
    }

    @PostMapping
    public ResponseResult add(@RequestBody User user) {
        int res = userService.saveUser(user);
        return new ResponseResult(res, "add res: " + res);
    }

    @PutMapping
    public ResponseResult update(@RequestBody User user) {
        int res = userService.updateUser(user);
        return new ResponseResult(res, "add res: " + res);
    }
}
