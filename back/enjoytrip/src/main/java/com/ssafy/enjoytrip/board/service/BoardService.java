package com.ssafy.enjoytrip.board.service;

import java.util.List;
import java.util.Map;

import com.ssafy.enjoytrip.board.dto.BoardDto;
import com.ssafy.enjoytrip.board.dto.ReplyDto;

public interface BoardService {

	void writePost(BoardDto boardDto) throws Exception;

	List<BoardDto> getPostList(Map<String, Object> map) throws Exception;

	BoardDto getPost(String postId) throws Exception;

	void updatePost(BoardDto boardDto) throws Exception;

	void deletePost(String postId) throws Exception;

	List<BoardDto> getUserPostList(String userId) throws Exception;

	void writeReply(ReplyDto replyDto) throws Exception;

	void deleteReply(String replyId) throws Exception;

	void updateReply(ReplyDto replyDto) throws Exception;

	List<ReplyDto> getReplyList(String postId) throws Exception;

}
