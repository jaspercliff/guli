package com.atguigu.Controller;

import cn.hutool.core.lang.hash.Hash;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jasper
 * @date 2023/5/9
 */
@Api("admin login")
@RestController
@RequestMapping("/eduservice/user")
public class EduLoginController {
    /**
     * login
     */
    @PostMapping("login")
    public Map<String, String> login() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("token","admin");
        return map;
    }

    @GetMapping("info")
    public Map<String, String> info() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","admin");
        map.put("avatar","https://ts4.cn.mm.bing.net/th?id=OIP-C.Ido-nzOdM7Qw4Iki83BsNgHaHZ&w=250&h=249&c=8&rs=1&qlt=90&o=6&dpr=2.2&pid=3.1&rm=2");
        return map;
    }
}
