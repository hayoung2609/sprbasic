package org.example.sprbasic.service.Impl;

import org.example.sprbasic.domain.User;
import org.example.sprbasic.dto.DefaultDto;
import org.example.sprbasic.dto.UserDto;
import org.example.sprbasic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.example.sprbasic.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

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
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));

        return UserDto.DetailResDto.builder().id(user.getId())
                .deleted(user.getDeleted()).createdAt(user.getCreatedAt())
                .modifiedAt(user.getModifiedAt()).username(user.getUsername()).build();
    }

    @Override
    public UserDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }

    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param) {
        List<UserDto.DetailResDto> resultList = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User each : list) {
            boolean isSearched = true;
            if(param.getDeleted() != null){
                System.out.println("param.getDeleted() not null?");
                if(each.getDeleted() != param.getDeleted()){
                    isSearched = false;
                    System.out.println("param.getDeleted() false");
                    System.out.println("param.getName(): " + isSearched);
                }
            }
            if(param.getName() != null && !param.getName().isEmpty()){
                System.out.println("param.getName() not null?");
                if(!each.getName().contains(param.getName())){
                    isSearched = false;
                    System.out.println("param.getName() : " + isSearched);
                }
            }
            if(param.getPhone() != null && !param.getPhone().isEmpty()){
                System.out.println("param.getPhone() not null?");
                if(!each.getPhone().contains(param.getPhone())){
                    isSearched = false;
                    System.out.println("param.getPhone() : " + isSearched);
                }
            }
            if(isSearched){
                resultList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
            }
        }
        return resultList;
    }
}