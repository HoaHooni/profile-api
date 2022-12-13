package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Project")
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@SuperBuilder
public class ProjectEntity extends BaseEntity<Long> {

    @Column(name = "title")
    private String title;

    @Column(name = "short-description")
    private String shortDescription;

    @Column(name = "description")
    private String description;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "url")
    private String url;

    @Column(name = "team-size")
    private Integer teamSize;

    @Column(name = "responsible")
    private String responsible;

    @Column(name = "languages")
    private String languages;

    @Column(name = "tools")
    private String tools;

    @Column(name = "other")
    private String other;

    @Column(name = "from_date")
    private Timestamp fromDate;

    @Column(name = "to_date")
    private Timestamp toDate;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false, referencedColumnName = "id")
    private UserEntity user;
}
