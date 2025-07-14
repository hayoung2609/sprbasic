package org.example.sprbasic.domain;

import jakarta.persistence.*;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false)
    @Setter
    protected Boolean createdAt; // 생성일시

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    @Setter
    protected Boolean modifiedAt; // 수정일시

    @PrePersist
    public void prePersist() {this.createdAt = true;}
}
