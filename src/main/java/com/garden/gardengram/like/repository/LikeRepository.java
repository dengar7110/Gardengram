package com.garden.gardengram.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garden.gardengram.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer>{

}
