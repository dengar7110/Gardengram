package com.garden.gardengram.comment.reposiotry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garden.gardengram.comment.domain.Comment;

import jakarta.transaction.Transactional;

public interface CommentRepository extends JpaRepository<Comment, Integer >{

	// WHERE `postId` = #{postId}
	public List<Comment> findByPostId(int postId);
	
	@Transactional
	public void deleteByPostId(int postId);
	
}
