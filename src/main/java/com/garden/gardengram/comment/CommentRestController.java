package com.garden.gardengram.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentRestController {
	
	@PostMapping("/post/comment/create")
	public Map<String, String> comment() {
		
		Map<String, String> resultMap = new HashMap<>();
		
		
		
		return resultMap;
	}

}
