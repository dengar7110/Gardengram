package com.garden.gardengram.post.dto;

import java.util.List;

import com.garden.gardengram.comment.dto.CommentView;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CardView {

	private int postId;
	private int userId;
	
	private String contents;
	private String imagePath;
	
	private String loginId;
	
	private int likeCount;
	
	private boolean isLike;
	
	private List<CommentView> commentList;
	
	
}
