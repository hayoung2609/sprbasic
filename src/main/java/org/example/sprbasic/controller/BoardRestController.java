package org.example.sprbasic.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("/api/board")
@RestController // ResponseBody는 html같은 객체를 직접 전달해주는 역할
public class BoardRestController {

    List<Map<String, Object>> list = new ArrayList<>();
    int tempId = 0;

    @RequestMapping("/create")
    public Map<String, Object> create(
            //@RequestParam String title, String content, String author
            @RequestParam Map<String, Object> param
    ) {
        String title = param.get("title").toString();
        String content = param.get("content").toString();
        String author = param.get("author").toString();

        /*
        System.out.println(title);
        System.out.println(content);
        System.out.println(author);
        */

        Map<String, Object> map_board = new HashMap<>();
        map_board.put("id", ++tempId);
        map_board.put("title", title);
        map_board.put("content", content);
        list.add(map_board);

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("totalsize", list.size());

        return map_result;
    }

    @RequestMapping("/list")
    public Map<String, Object> list(){
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("totalsize", list.size());
        map_result.put("list", list);
        return map_result;
    }

    @RequestMapping("/detail")
    public Map<String, Object> detail(@PathVariable int id){
        Map<String, Object> map_board = null;
        for(Map<String, Object> each : list){
            int eachId = Integer.parseInt(each.get("id").toString());
            if(eachId == id){
                map_board = each;
            }
        }
        int result_code = 0;
        if(map_board != null){
            result_code = 200;
        }

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", result_code);
        map_result.put("board", map_board);
        return map_result;
    }
}
