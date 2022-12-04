package com.example.demo.domain;

import com.example.demo.common.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

    @Column(name = "createAt")
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Long createAt;

    @Column(name = "updateAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Long upateAt;

    @Column(name = "createBy")
    private String createBy;

    @Column(name = "updateBy")
    private String updateBy;

    @Column(name = "status", length = 30, columnDefinition = "varchar(30) default 'ACTIVE'")
    @Enumerated(value = EnumType.STRING)
    private EStatus status;

    @PrePersist
    public void prePersit() {
        this.createAt = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        this.upateAt = System.currentTimeMillis();
    }

}
