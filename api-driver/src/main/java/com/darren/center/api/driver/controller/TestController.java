package com.darren.center.api.driver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * <h3>spring-cloud-2020</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年08月19日 13:49:51
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    /**
     * 测试zuul
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/hello")
    public String hello(@RequestParam String name, @RequestParam  Integer age){
        log.info("name:{}, age:{}", name, age);
        String[] str = new String[]{name, age.toString()};
        return Arrays.toString(str);
    }

    /**
     * 测试zuul - 敏感Header
     * @param req
     * @return
     */
    @RequestMapping("/token")
    public String cookie(HttpServletRequest req) {
        String token = req.getHeader("token");
        System.out.println("token:"+token);
        return "api-driver-token:"+token;
    }

}
