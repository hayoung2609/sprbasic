package org.example.sprbasic.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class) //이게 있어야 자동으로 값 넣어줌!!
@Setter
@Getter
@Entity // 고유값이 있어야함
public class Board extends AuditingField {
    /*
    @Id // @Id는 테이블에서 PK로 사용됨. 무조건 unique 해야함.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 값 자동으로 올려줌.
    Long id;
    */

    String title;
    String content;
    String author;

    protected Board() {} // 안 쓸거지만 일단 선언.
    private Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    } // 이 생정자 못 쓰게 함.

    // 이 메서드를 통해서만 데이터 생성 가능.
    public static Board of(String title, String content, String author) {
        return new Board(title, content, author);
    }
}