package org.example.sprbasic.controller;

import lombok.RequiredArgsConstructor;
import org.example.sprbasic.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.*;

@RequiredArgsConstructor
@RequestMapping("/api/post")
@RestController
public class PostRestController {

    final PostService postService;

    @GetMapping("/create") // GET으로만 접근 가능
    public Map<String, Object> create(@RequestParam Map<String, Object> param) {
        return postService.create(param);
    }

    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        return postService.list();
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id) {
        return postService.detail(id);
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> param) {
        return postService.update(param);
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(int id){
        return postService.delete(id);
    }
}
