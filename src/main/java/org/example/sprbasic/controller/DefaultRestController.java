package org.example.sprbasic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api") // 전체 메서드의 주소값 앞에 더해짐
@RestController
public class DefaultRestController {

    @RequestMapping("/calculate") // /api/calculate랑 같음
    public Map<String, Object> calculate(int a, int b){
        Map<String, Object> map = new HashMap<>();
        map.put("sum", a + b);
        return map;
    }

    @RequestMapping("/calculate3")
    public Map<String, Object> calculate3(int a, int b){
        Map<String, Object> map = new HashMap<>();
        map.put("mul", a * b);
        return map;
    }

}
