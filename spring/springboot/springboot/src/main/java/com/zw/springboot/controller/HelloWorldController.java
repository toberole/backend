package com.zw.springboot.controller;

import com.zw.springboot.domain.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        System.out.println("Hello ......");
        return "Hello_" + System.currentTimeMillis();
    }

    /**
     * GET
     * http://localhost:8080/demo/123?name=test
     */
    @GetMapping("/demo/{id}")
    public String demo(@PathVariable(name = "id") String id, @RequestParam(name = "name") String name) {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        return "id: " + id + ",name: " + name;
    }

    @PostMapping(path = "/demo1")
    public String demo1(@RequestBody Person person) {
        System.out.println("name: " + person.name);
        return person.toString();
    }

    @PostMapping(path = "/demo2")
    public void demo2(Person person) {
        System.out.println(person.toString());
    }

    @GetMapping("/demo3")
    public void demo3(@RequestHeader(name = "myHeader") String myHeader,
                      @CookieValue(name = "myCookie") String myCookie) {
        System.out.println("myHeader=" + myHeader);
        System.out.println("myCookie=" + myCookie);
    }
}
