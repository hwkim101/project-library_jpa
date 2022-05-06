package com.example.library.api.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.api.entity.BookEntity;
import com.example.library.api.entity.Message;
import com.example.library.api.entity.StatusEnum;
import com.example.library.api.repo.BookRepository;
import com.example.library.api.repo.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/book")
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@PostMapping(value="/list")
    public @ResponseBody List<BookEntity> list(BookEntity bookEntity) {
		log.debug(">>>>>>>>>>>>>>>>commit test");
		List<BookEntity> list = new ArrayList();
		list = bookRepository.findAll(); 
		list.stream().forEach(book -> System.out.println(book.getBookNm()));
        return list;
    }
	
	@PostMapping(value="/")
    public @ResponseBody String index() {
	
        return "HI";
    }

	@PostMapping(value="/insert")
    public @ResponseBody ResponseEntity<Message> insert(@RequestBody BookEntity bookEntity) {
		log.debug(">>>>>insert>>>>>>>>>>>"+bookEntity.toString());
		Message message = new Message();
		int isPresentCategory = categoryRepository.countByCategoryCd(bookEntity.getCategoryCd());
		if(isPresentCategory == 0) {
			message.setStatus(StatusEnum.BAD_REQUEST);
			message.setMessage("해당 카테고리가 존재하지않습니다");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		message.setStatus(StatusEnum.OK);
		message.setData(isPresentCategory);
		bookRepository.save(bookEntity);
		return new ResponseEntity<>(message, HttpStatus.OK);
    }
	
	@GetMapping(value = "/healthcheck")
    public ResponseData healthcheck(String format) {
        System.out.println(format);
        ResponseData data = new ResponseData();
        
        data.setStatus("ok");
        LocalDateTime ldt = LocalDateTime.now();
        ZoneId zi = ZoneId.of("Asia/Seoul");
        data.setCurrentTime(ldt);
        return data;
    }
	
	
	public class ResponseData{
        private String status;
        private LocalDateTime currentTime;

        public String getStatus(){
            return this.status;
        }
        public void setStatus(String status){
            this.status = status;
        }
        public LocalDateTime getCurrentTIme(){
            return this.currentTime;
        }
        public void setCurrentTime(LocalDateTime currentTime){
            this.currentTime = currentTime;
        }
    }
}
