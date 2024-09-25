package com.garden.gardengram.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.garden.gardengram.comment.domain.Comment;
import com.garden.gardengram.comment.dto.CommentView;
import com.garden.gardengram.comment.reposiotry.CommentRepository;
import com.garden.gardengram.user.domain.User;
import com.garden.gardengram.user.service.UserService;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	private UserService userSerivce;
	
	public CommentService(
			CommentRepository commentRepository
			, UserService userService) {
		this.commentRepository = commentRepository;
		this.userSerivce = userService;
	}

	public Comment addComment(int postId, int userId, String contents) {
		
		Comment comment = Comment.builder()
						.postId(postId)
						.userId(userId)
						.contents(contents)
						.build();
		
		return commentRepository.save(comment);
	}

	// 댓글 목록 조회
	public List<CommentView> getCommentListByPostId(int postId) {
		
		List<Comment> commentList = commentRepository.findByPostId(postId);
		
		List<CommentView> commentViewList = new ArrayList<>();
		
		for(Comment comment:commentList) {
			
			int userId = comment.getUserId();
			User user = userSerivce.getUserById(userId);
			
			CommentView commentView = CommentView.builder()
									.commentId(comment.getId())
									.userId(userId)
									.contents(comment.getContents())
									.loginId(user.getLoginId())
									.build();
			
			commentViewList.add(commentView);
		}
		
		return commentViewList;
	}
	
	public void deleteCommentByPostId(int postId) {
		commentRepository.deleteByPostId(postId);
	}
	
		
	
	
}
