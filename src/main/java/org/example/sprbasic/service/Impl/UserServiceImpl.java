package org.example.sprbasic.service.Impl;

import org.example.sprbasic.domain.User;
import org.example.sprbasic.dto.DefaultDto;
import org.example.sprbasic.dto.UserDto;
import org.example.sprbasic.mapper.UserMapper;
import org.example.sprbasic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.example.sprbasic.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final UserMapper userMapper;

    @Override
    public DefaultDto.CreateResDto create(UserDto.CreateReqDto param) {
        return userRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(UserDto.UpdateReqDto param) {
        User User = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ User.setDeleted(param.getDeleted()); }
        if(param.getPassword() != null){ User.setPassword(param.getPassword()); }
        if(param.getName() != null){ User.setName(param.getName()); }
        if(param.getPhone() != null){ User.setPhone(param.getPhone()); }
        userRepository.save(User);
    }

    @Override
    public void delete(UserDto.UpdateReqDto param) {
        /*
        // 0번 방법!
        boardRepository.delete(board); // 완전 삭제!

        // 1번 방법!
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        board.setDeleted(true);
        boardRepository.save(board); // 소프트 딜리트!
        */

        // 2번 방법!
        update(UserDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public UserDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        UserDto.DetailResDto res = userMapper.detail(param);
        return res;
        /*
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));

        return UserDto.DetailResDto.builder().id(user.getId())
                .deleted(user.getDeleted()).createdAt(user.getCreatedAt())
                .modifiedAt(user.getModifiedAt()).username(user.getUsername()).build();
         */
    }

    @Override
    public UserDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }

    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param) {
        List<UserDto.DetailResDto> resultList = new ArrayList<>();
        List<UserDto.DetailResDto> list = userMapper.list(param);
        for(UserDto.DetailResDto each : list){
            resultList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return resultList;
    }


    @Override
    public DefaultDto.PagedListResDto pagedList(UserDto.PagedListReqDto param) {
        int totalCount = userMapper.pagedListCount(param);
        //한번에 볼 페이지수 부터 정리!
        int perpage = 10;
        if(param.getPerpage() != null){
            perpage = param.getPerpage();
        }
        if(perpage < 2){
            perpage = 2;
        }
        param.setPerpage(perpage);

        // 전체 글 갯수를 활용해서 전체 페이지수 정리!
        int totalPage = totalCount / perpage;
        if(totalCount % perpage > 0){
            totalPage++;
        }

        // 내 요청 페이지가 정상적인지 검토!
        int callpage = 1;
        if(param.getCallpage() != null){
            callpage = param.getCallpage();
        }
        if(callpage > totalPage){
            callpage = totalPage;
        }
        if(callpage < 1){
            callpage = 1;
        }
        param.setCallpage(callpage);

        // 순번 계산!
        int offset = (callpage - 1) *  perpage;
        param.setOffset(offset);

        List<UserDto.DetailResDto> list = userMapper.pagedList(param);
        List<UserDto.DetailResDto> returnList = new ArrayList<>();
        for(UserDto.DetailResDto each : list){
            returnList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }

        DefaultDto.PagedListResDto res =
                DefaultDto.PagedListResDto.builder()
                        .callpage(callpage)
                        .perpage(perpage)
                        .totalpage(totalPage)
                        .totalcount(totalCount)
                        .list(returnList)
                        .build();

        return res;
    }
}