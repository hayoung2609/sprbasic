package org.example.sprbasic.controller;

import lombok.RequiredArgsConstructor;
import org.example.sprbasic.dto.BoardDto;
import org.example.sprbasic.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController // 중요한 개념 아래에 적음.
public class BoardRestController {

    final BoardService boardService;

    @PostMapping("")
    public BoardDto.CreateResDto create(@RequestBody BoardDto.CreateReqDto param){
        return boardService.create(param);
    }
    @PutMapping("")
    public void update(@RequestBody BoardDto.UpdateReqDto param){
        boardService.update(param);
    }
    @DeleteMapping("")
    public void delete(@RequestBody BoardDto.UpdateReqDto param){
        boardService.delete(param.getId());
    }

    @GetMapping("/detail/{id}")
    public BoardDto.DetailResDto detail(@PathVariable long id){
        return boardService.detail(id);
    }
    @GetMapping("/list")
    public List<BoardDto.DetailResDto> list(){
        return boardService.list();
    }
}