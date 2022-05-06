package com.example.library.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@DynamicInsert
@Table(name = "tb_book")
public class BookEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int book_id;
	@Column(name ="book_nm", length = 100) 
	private String bookNm;
	
	@Column(name ="category_cd",nullable = false, length = 30) 
	private String categoryCd;
	@Column(name ="title", length = 200)
	private String title;
	@Column(name ="userNm", length = 200)
	private String user_nm;
	
	@Column(name ="suspension_yn", length = 1, columnDefinition="N")
	private String suspensionYn;
	@Column(name="suspension_desc",length = 10) 
	private String suspensionDesc;
	@CreationTimestamp
	private LocalDateTime  create_time = LocalDateTime.now();

	@LastModifiedDate
	private LocalDateTime  update_time = LocalDateTime.now();
	

	
}
