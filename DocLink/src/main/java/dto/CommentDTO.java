package dto;

import com.doclink.model.Comment;
import com.doclink.model.Post;

import lombok.Data;

@Data
public class CommentDTO {
	
	public CommentDTO(Comment comment) {
		
		this.date = comment.getDate();
		this.description = comment.getDescription();
		this.posts = comment.getPosts();
	}
	
	private String date;
	private String description;
	private Post posts;
	
	
}
