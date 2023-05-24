package com.ssafy.enjoytrip.board.service;

import java.util.List;
import java.util.Map;

import com.ssafy.enjoytrip.board.dto.BoardDto;

public interface BoardService {

	void writePost(BoardDto boardDto) throws Exception;

	List<BoardDto> getPostList(Map<String, Object> map) throws Exception;

	BoardDto getPost(String postId) throws Exception;

	void updatePost(BoardDto boardDto) throws Exception;

	void deletePost(String postId) throws Exception;

	List<BoardDto> getUserPostList(String userId) throws Exception;

}
