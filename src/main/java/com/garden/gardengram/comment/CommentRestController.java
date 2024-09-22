package com.garden.gardengram.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garden.gardengram.comment.domain.Comment;
import com.garden.gardengram.comment.service.CommentService;

import jakarta.servlet.http.HttpSession;

@RestController
public class CommentRestController {
	
	private CommentService commentService;
	
	public CommentRestController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	
	@PostMapping("/post/comment/create")
	public Map<String, String> createComment(
			@RequestParam("postId") int PostId
			, @RequestParam("contents") String contents
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		Comment comment = commentService.addComment(PostId, userId, contents);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(comment != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}

}
