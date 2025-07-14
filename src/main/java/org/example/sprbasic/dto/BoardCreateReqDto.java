package org.example.sprbasic.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardCreateReqDto {
    String title;
    String content;
    String author;
}
