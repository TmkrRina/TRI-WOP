package dto;

import com.doclink.model.Doctor;

import lombok.Data;

@Data
public class DoctorDTO {
	public DoctorDTO(Doctor doc) {
		super();
		this.specialization = doc.getSpecialization();
		this.experience = doc.getExperience();
	}
	private String specialization;
	private String experience;

}
