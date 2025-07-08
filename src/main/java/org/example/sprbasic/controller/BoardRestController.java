package org.example.sprbasic.controller;

import lombok.RequiredArgsConstructor;
import org.example.sprbasic.service.BoardService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController // 중요한 개념일수록 아래에 적는 스타일
public class BoardRestController {

    final BoardService boardService;

    @RequestMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> param){
        return boardService.create(param);
    }
    @RequestMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> param){
        return boardService.update(param);
    }
    @RequestMapping("/delete")
    public Map<String, Object> delete(@RequestParam int id){
        return boardService.delete(id);
    }

    @RequestMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id){
        return boardService.detail(id);
    }
    @RequestMapping("/list")
    public Map<String, Object> list(){
        return boardService.list();
    }
}