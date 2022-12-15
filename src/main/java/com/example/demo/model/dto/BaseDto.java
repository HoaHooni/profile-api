package com.example.demo.model.dto;

import com.example.demo.common.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@SuperBuilder
public abstract class BaseDto<T> {

    private T id;

    private Long createAt;

    private Long updateAt;

    private String createBy;

    private String updateBy;

    private EStatus status;

    @Override
    public int hashCode() {
        return Objects.hash(createAt, id);
    }

    @PrePersist
    public void prePersist() {
        this.createAt = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        this.updateAt = System.currentTimeMillis();
    }
}
