package com.example.library.api.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_category")
public class CategoryEntity {

	@Id
	@Column(name ="category_cd", length = 10) 
	private String categoryCd;
	@Column(name ="category_nm", length = 50)
	private String categoryNm;
	@CreatedDate
	private Date create_time;
	@LastModifiedDate
	private Date update_time;
	

	
}
