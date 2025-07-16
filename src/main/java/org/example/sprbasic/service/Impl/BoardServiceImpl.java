package org.example.sprbasic.service.Impl;

import org.example.sprbasic.domain.Board;
import org.example.sprbasic.dto.BoardDto;
import org.example.sprbasic.dto.DefaultDto;
import org.example.sprbasic.repository.BoardRepository;
import org.example.sprbasic.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    final BoardRepository boardRepository;

    @Override
    public DefaultDto.CreateResDto create(BoardDto.CreateReqDto param) {
        return boardRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(BoardDto.UpdateReqDto param) {
        Board board = boardRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ board.setDeleted(param.getDeleted()); }
        if(param.getTitle() != null){ board.setTitle(param.getTitle()); }
        if(param.getContent() != null){ board.setContent(param.getContent()); }
        if(param.getAuthor() != null){ board.setAuthor(param.getAuthor()); }
        boardRepository.save(board);
    }

    @Override
    public void delete(long id) {
        /*
        // 0번 방법!
        boardRepository.delete(board); // 완전 삭제!

        // 1번 방법!
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        board.setDeleted(true);
        boardRepository.save(board); // 소프트 딜리트!
        */

        // 2번 방법!
        update(BoardDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }

    public BoardDto.DetailResDto get(long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));

        return BoardDto.DetailResDto.builder().id(board.getId())
                .deleted(board.getDeleted()).createdAt(board.getCreatedAt())
                .modifiedAt(board.getModifiedAt()).title(board.getTitle())
                .content(board.getContent()).author(board.getAuthor()).build();
    }

    @Override
    public BoardDto.DetailResDto detail(long id) {
        return get(id);
    }

    @Override
    public List<BoardDto.DetailResDto> list() {
        List<BoardDto.DetailResDto> resultList = new ArrayList<>();
        List<Board> list = boardRepository.findAll();
        for (Board each : list) {
            resultList.add(get(each.getId()));
        }
        return resultList;
    }
}