package dto;

import com.doclink.model.User;
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
	public UserDTO() {}
	
	public UserDTO(User user) {
		this.fname = user.getFname();
		this.lname=user.getLname();
		this.email = user.getEmail();
		this.gender=user.getGender();
		this.state = user.getState();
		this.country=user.getCountry();
		this.profile_img = user.getProfile_img();
		this.confirmed_email=user.getConfirmed_email();
		this.role = user.getRole();
		
	}
}