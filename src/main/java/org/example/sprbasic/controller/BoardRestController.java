package org.example.sprbasic.controller;

import lombok.RequiredArgsConstructor;
import org.example.sprbasic.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController // 중요한 개념 아래에 적음.
public class BoardRestController {

    final BoardService boardService;

    @PostMapping("")
    public Map<String, Object> create(@RequestBody Map<String, Object> param){
        return boardService.create(param);
    }
    @PutMapping("")
    public Map<String, Object> update(@RequestBody Map<String, Object> param){
        return boardService.update(param);
    }
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody Map<String, Object> param){
        Long id = Long.parseLong(param.get("id").toString());
        return boardService.delete(id);
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable long id){
        return boardService.detail(id);
    }
    @GetMapping("/list")
    public Map<String, Object> list(){
        return boardService.list();
    }

}