package org.example.sprbasic.mapper;

import org.example.sprbasic.domain.User;
import org.example.sprbasic.dto.DefaultDto;
import org.example.sprbasic.dto.UserDto;

import java.util.List;

public interface UserMapper {
    // 상세 조회
    UserDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    // 목록
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
    //페이징 처리를 위한 것
    List<UserDto.DetailResDto> pagedList(UserDto.PagedListReqDto param);
    int pagedListCount(UserDto.PagedListReqDto param);
}

