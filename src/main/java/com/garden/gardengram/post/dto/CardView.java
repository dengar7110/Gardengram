package com.garden.gardengram.post.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CardView {

	private int PostId;
	private int UserId;
	
	private String contents;
	private String imagePath;
	
	private String loginId;
	
}
