package com.orive.Training.Entity;


import com.orive.Training.Config.AesEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trainers_list")
public class TrainersListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainersListId;
	
	@Column(name = "trainers_full_name")
	@Convert(converter = AesEncryptor.class)
	private String trainersFullName;
	
	@Column(name = "email_address")
	@Convert(converter = AesEncryptor.class)
	private String emailAddress;
	
	@Column(name = "phone_no")
	@Convert(converter = AesEncryptor.class)
	private Long phoneNo;
	
	@Column(name = "technical_skills")
	@Convert(converter = AesEncryptor.class)
	private String technicalSkills;
	
	@Column(name = "soft_skills")
	@Convert(converter = AesEncryptor.class)
	private String softSkills;
	
	@Column(name = "industries")
	@Convert(converter = AesEncryptor.class)
	private String industries;
	
	@Column(name = "certifications")
	@Convert(converter = AesEncryptor.class)
	private String certifications;
	
	@Column(name = "training_programs_offered")
	@Convert(converter = AesEncryptor.class)
	private String trainingProgramsOffered;
	
	@Column(name = "preferred_training_audienece")
	@Convert(converter = AesEncryptor.class)
	private String preferredTrainingAudienece;
	
	@Column(name = "training_languages")
	@Convert(converter = AesEncryptor.class)
	private String trainingLanguages;
	
	@Column(name = "availability")
	@Convert(converter = AesEncryptor.class)
	private String availability;
	
	@Column(name = "previous_clients")
	@Convert(converter = AesEncryptor.class)
	private String previousClients;
	
	@Column(name = "training_materials_provided")
	@Convert(converter = AesEncryptor.class)
	private String trainingMaterialsProvided;
	
	@Column(name = "additional_notes")
	@Convert(converter = AesEncryptor.class)
	private String additionalNotes;
}
