package com.garden.gardengram.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garden.gardengram.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	// ORDER BY `id` DESC
	public List<Post> findAllByOrderByIdDesc();
	
	// WHERE `id` = #{id} AND `userId` = #{userId}
	public Optional<Post> findByIdAndUserId(int id, int userId);
	
}
