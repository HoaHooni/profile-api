package com.example.demo.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.example.demo.common.EStatus;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
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
	private Timestamp createAt;

	@Column(name = "updateAt")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp upateAt;

	@Column(name = "createBy")
	private String createBy;

	@Column(name = "updateBy")
	private String updateBy;

	@Column(name = "status",length = 30, columnDefinition = "varchar(30) default 'ACTIVE'")
	@Enumerated(value = EnumType.STRING)
	private EStatus status;
	
	
}
