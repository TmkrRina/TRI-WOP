package dto;

import com.doclink.model.PostModel;
import com.doclink.model.UserModel;
import com.doclink.model.UserRole;

import lombok.Data;

@Data
public class UserDTO {
	private String fname;
	private String lname;
	private String email;
	
	private String gender;
	private String state;
	private String country;
	private String profile_img;
	private Boolean confirmed_email;
	private UserRole role;
	private PostModel post;
	public UserDTO() {}
	
	public UserDTO(UserModel userModel) {
		this.fname = userModel.getFname();
		this.lname=userModel.getLname();
		this.email = userModel.getEmail();
		this.gender=userModel.getGender();
		this.state = userModel.getState();
		this.country=userModel.getCountry();
		this.profile_img = userModel.getProfile_img();
		this.confirmed_email=userModel.getConfirmed_email();
		this.role = userModel.getRole();
		this.post=userModel.getPost();
		
	}
}