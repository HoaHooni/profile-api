package com.example.demo.model.dto;

import javax.persistence.MappedSuperclass;

import com.example.demo.common.EStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public class BaseDto<T> {
	
	private T id;
	
	private Long createAt;
	
	private Long upateAt;
	
	private String createBy;
	
	private String updateBy;
	
	private EStatus stattus;
	
}
