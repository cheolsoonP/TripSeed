package com.ssafy.enjoytrip.board.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.board.dto.BoardDto;
import com.ssafy.enjoytrip.board.dto.ReplyDto;

@Mapper
public interface BoardMapper {

	void writePost(BoardDto boardDto) throws SQLException;

	List<BoardDto> getPostList(Map<String, Object> map) throws SQLException;

	BoardDto getPost(String postId) throws SQLException;

	void updatePost(BoardDto boardDto) throws SQLException;

	void deletePost(String postId) throws SQLException;

	List<BoardDto> getUserPostList(String userId) throws SQLException;

	void writeReply(ReplyDto replyDto) throws SQLException;

	void deleteReply(String replyId) throws SQLException;

	void updateReply(ReplyDto replyDto) throws SQLException;

	List<ReplyDto> getReplyList(String postId) throws SQLException;

	void addView(String postId) throws SQLException;

}
