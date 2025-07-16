package org.example.sprbasic.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.sprbasic.dto.DefaultDto;

@Setter
@Getter
@Entity
public class User extends AuditingField {
    String username;
    String password;
    String name;
    String phone;

    protected User() {}
    private User(String username, String password, String name, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public static User of(String username, String password, String name, String phone) {
        return new User(username, password, name, phone);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}