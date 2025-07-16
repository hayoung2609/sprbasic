package org.example.sprbasic.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.sprbasic.domain.User;

public class UserDto {
    @Setter @Getter @Builder
    public static class CreateReqDto {
        String username;
        String password;
        String name;
        String phone;

        public User toEntity() {
            return User.of(getUsername(), getPassword(), getName(), getPhone());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        String password;
        String name;
        String phone;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto {
        String username;
        String name;
        String phone;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto extends DefaultDto.ListReqDto {
        String password;
        String name;
        String phone;
    }
}
