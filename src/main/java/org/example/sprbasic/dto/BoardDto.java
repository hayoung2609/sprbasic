package org.example.sprbasic.dto;

import lombok.*;

public class BoardDto {
    @Setter @Getter
    public static class CreateReqDto {
        String title;
        String content;
        String author;
    }

    @Setter @Getter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }

    @Setter @Getter
    public static class UpdateReqDto {
        Long id;
        String title;
        String content;
        String author;
    }

    @Setter @Getter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;
        String title;
        String content;
        String author;
    }
}
