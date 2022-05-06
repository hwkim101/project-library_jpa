package com.example.library.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.api.entity.BookEntity;
import com.example.library.api.entity.CategoryEntity;
import com.example.library.api.entity.Message;
import com.example.library.api.entity.StatusEnum;
import com.example.library.api.repo.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
	@PostMapping(value="/list")
    public @ResponseBody List<CategoryEntity> list(BookEntity bookEntity) {
		
		List<CategoryEntity> list = categoryRepository.findAll(); 
		
        return list;
    }

	@PostMapping(value="/insert")
    public @ResponseBody ResponseEntity<Message> insert(@RequestBody CategoryEntity categoryEntity) {
		log.debug(">>>>>insert>>>>>>>>>>>"+categoryEntity.toString());
		
		Message message = new Message();
		message.setStatus(StatusEnum.OK);
		//message.setData(isPresentCategory);
		categoryRepository.save(categoryEntity);
		return new ResponseEntity<>(message, HttpStatus.OK);
    }
	
}
