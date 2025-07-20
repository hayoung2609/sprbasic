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
}

