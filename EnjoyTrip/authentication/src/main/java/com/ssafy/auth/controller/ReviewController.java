package com.ssafy.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
	@PostMapping
	public ResponseEntity<String> writeReview(Authentication authentication){
		/* 원래 review service만들고 사용자가 보낸 comment 내용하고
		 * username하고 사용자 정보를 가지고 DB에 insert를 할 수 있는데 그 부분은 뒤에서 하도록 한다.
		 */
		// Authentication 으로 꺼내진 Username 확인할 수 있다. 
		return ResponseEntity.ok().body(authentication.getName() + "님의 리뷰 등록이 완료 되었습니다.");
	}
}
