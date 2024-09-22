package com.garden.gardengram.comment.service;

import org.springframework.stereotype.Service;

import com.garden.gardengram.comment.domain.Comment;
import com.garden.gardengram.comment.reposiotry.CommentRepository;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	public Comment addComment(int postId, int userId, String contents) {
		
		Comment comment = Comment.builder()
						.postId(postId)
						.userId(userId)
						.contents(contents)
						.build();
		
		return commentRepository.save(comment);
	}
	
	
}
