package dto;

import com.doclink.model.PostModel;
import com.doclink.model.UserModel;

import lombok.Data;

@Data
public class PostDTO {
	private  UserDTO  user;
	private String title;
	private String description;
	private String date;
	
	public PostDTO() {}
	
	public PostDTO(PostModel postModel) {
		this.title = postModel.getTitle();
		this.user = new UserDTO(postModel.getUser());
		this.description = postModel.getDescription();
		this.date=postModel.getDate();
	}
}
