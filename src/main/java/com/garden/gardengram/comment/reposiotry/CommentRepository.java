package com.garden.gardengram.comment.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garden.gardengram.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer >{

}
