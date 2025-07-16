package org.example.sprbasic.service;

import org.example.sprbasic.dto.BoardDto;
import org.example.sprbasic.dto.DefaultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    DefaultDto.CreateResDto create(BoardDto.CreateReqDto param);
    void update(BoardDto.UpdateReqDto param);
    void delete(long id);
    BoardDto.DetailResDto detail(long id);
    List<BoardDto.DetailResDto> list();
}
