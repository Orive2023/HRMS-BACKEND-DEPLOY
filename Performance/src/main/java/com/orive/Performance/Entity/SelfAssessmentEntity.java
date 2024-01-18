package com.orive.Performance.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.orive.Performance.Config.AesEncryptor;

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
@Table(name = "self_assessment")
public class SelfAssessmentEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "selfassessment-sequence")
    @GenericGenerator(name = "selfassessment-sequence", strategy = "com.orive.Performance.Entity.SelfAssessmentIdGenerator")
	private String selfAssessmentId;
	
	@Column(name = "performance_goal_rating")
	@Convert(converter = AesEncryptor.class)
	private int performanceGoalRating;
	
	@Column(name = "performance_goal_comments")
	@Convert(converter = AesEncryptor.class)
	private String performanceGoalComments;
	
	@Column(name = "new_skills_rating")
	@Convert(converter = AesEncryptor.class)
	private int newSkillsRating;
	
	@Column(name = "new_skills_comments")
	@Convert(converter = AesEncryptor.class)
	private String newSkillsComments;
	
	@Column(name = "collaboration_rating")
	@Convert(converter = AesEncryptor.class)
	private int collaborationRating;
	
	@Column(name = "collaboration_comments")
	@Convert(converter = AesEncryptor.class)
	private String collaborationComments;
	
	@Column(name = "managed_your_time_rating")
	@Convert(converter = AesEncryptor.class)
	private int managedYourTimeRating;
	
	@Column(name = "managed_your_time_comments")
	@Convert(converter = AesEncryptor.class)
	private String managedYourTimeComments;
	
	@Column(name = "improved_communication_skill_rating")
	@Convert(converter = AesEncryptor.class)
	private int improvedCommunicationSkillRating;
	
	@Column(name = "improved_communication_skill_comments")
	@Convert(converter = AesEncryptor.class)
	private String improvedCommunicationSkillComments;
}
