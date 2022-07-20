package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.example.demo.common.EStatus;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseEntity<T> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private T id;
	
	@Column(name = "createAt")
	@CreatedDate
	private Long createAt;
	
	@Column(name = "updateAt")
	@CreatedDate
	private Long upateAt;
	
	@Column(name = "createBy")
	@CreatedDate
	private String createBy;
	
	@Column(name = "updateBy")
	@CreatedDate
	private String updateBy;
	
	@Column(name = "status")
	private EStatus stattus;
}
