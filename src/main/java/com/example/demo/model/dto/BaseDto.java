package com.example.demo.model.dto;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.MappedSuperclass;

import com.example.demo.common.EStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@SuperBuilder
public abstract class BaseDto<T> {
	
	private T id;
	
	private Timestamp createAt;
	
	private Timestamp upateAt;
	
	private String createBy;
	
	private String updateBy;
	
	private EStatus status;

	@Override
	public int hashCode() {
		return Objects.hash(createAt, id);
	}

}
