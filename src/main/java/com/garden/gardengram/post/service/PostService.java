package com.garden.gardengram.post.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.garden.gardengram.common.FileManager;
import com.garden.gardengram.post.domain.Post;
import com.garden.gardengram.post.dto.CardView;
import com.garden.gardengram.post.repository.PostRepository;
import com.garden.gardengram.user.domain.User;
import com.garden.gardengram.user.service.UserService;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserService userService;
	
	public PostService(
			PostRepository postRepository
			, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}
	
	public Post addPost(int userId, String contents, MultipartFile file) {
		
		String urlPath = FileManager.saveFile(userId, file);
		
		Post post = Post.builder()
					.userId(userId)
					.contents(contents)
					.imagePath(urlPath)
					.build();
		
		Post result = postRepository.save(post);
		
		return result;
	}
	
	public List<CardView> getPostList() {
		
		List<Post> postList = postRepository.findAllByOrderByIdDesc();
		
		List<CardView> cardViewList = new ArrayList<>();
		
		for(Post post:postList) {
			
			int userId = post.getUserId();
			User user = userService.getUserById(userId);
			
			CardView cardView = CardView.builder()
								.PostId(post.getId())
								.UserId(userId)
								.contents(post.getContents())
								.imagePath(post.getImagePath())
								.loginId(user.getLoginId())
								.build();
			
			cardViewList.add(cardView);
		}
		
		return cardViewList;
	}
	
}
