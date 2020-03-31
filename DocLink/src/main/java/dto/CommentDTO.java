package dto;

import com.doclink.model.CommentModel;

import lombok.Data;

@Data
public class CommentDTO {
	public CommentDTO(CommentModel cm) {
		
		this.date = cm.getDate();
		this.description = cm.getDescription();
	}
	private String date;
	private String description;
	
	
}
