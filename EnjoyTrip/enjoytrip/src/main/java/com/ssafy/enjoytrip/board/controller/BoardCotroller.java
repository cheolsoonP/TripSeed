package com.ssafy.enjoytrip.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.board.dto.BoardDto;
import com.ssafy.enjoytrip.board.service.BoardService;

@RestController
@RequestMapping("/board")
@CrossOrigin("*")
public class BoardCotroller {
	private BoardService boardService;

	@Autowired
	public BoardCotroller(BoardService boardService) {
		this.boardService = boardService;
	}

	@PostMapping("/write")
	public ResponseEntity<?> writePost(BoardDto boardDto) {
		try {
			if (boardDto.getTitle() == null || boardDto.getContent() == null) {
				return new ResponseEntity<String>("제목과 내용을 모두 입력해야 합니다.", HttpStatus.BAD_REQUEST);
			}
			boardService.writePost(boardDto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}

	@GetMapping("/list")
	public ResponseEntity<?> getPostList(@RequestParam(value = "sido", required = false) Integer sidoCode,
			@RequestParam(value = "gugun", required = false) Integer gugunCode,
			@RequestParam(value = "keyword", required = false) String keyword) {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("sidoCode", sidoCode);
			map.put("gugunCode", gugunCode);
			map.put("keyword", keyword);
			List<BoardDto> postList;
			postList = boardService.getPostList(map);
			return new ResponseEntity<List<BoardDto>>(postList, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/view/{postId}")
	public ResponseEntity<?> getPost(@PathVariable("postId") String postId) {
		try {
			BoardDto boardDto = boardService.getPost(postId);
			if(boardDto != null) {
				return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/edit/{postId}")
	public ResponseEntity<?> updatePost(@PathVariable("postId") String postId,
										@RequestBody BoardDto boardDto) {
		try {
			if (boardDto.getTitle() == null || boardDto.getContent() == null) {
				return new ResponseEntity<String>("제목과 내용을 모두 입력해야 합니다.", HttpStatus.BAD_REQUEST);
			}
			boardDto.setContentId(Integer.parseInt(postId));
			boardService.updatePost(boardDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable("postId") String postId) {
		try {
			boardService.deletePost(postId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		
	}
	

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
