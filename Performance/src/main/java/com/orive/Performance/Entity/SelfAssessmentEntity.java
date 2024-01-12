package com.orive.Performance.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long selfAssessmentId;
	
	@Column(name = "performance_goal_rating")
	private int performanceGoalRating;
	
	@Column(name = "performance_goal_comments")
	private String performanceGoalComments;
	
	@Column(name = "new_skills_rating")
	private int newSkillsRating;
	
	@Column(name = "new_skills_comments")
	private String newSkillsComments;
	
	@Column(name = "collaboration_rating")
	private int collaborationRating;
	
	@Column(name = "collaboration_comments")
	private String collaborationComments;
	
	@Column(name = "managed_your_time_rating")
	private int managedYourTimeRating;
	
	@Column(name = "managed_your_time_comments")
	private String managedYourTimeComments;
	
	@Column(name = "improved_communication_skill_rating")
	private int improvedCommunicationSkillRating;
	
	@Column(name = "improved_communication_skill_comments")
	private String improvedCommunicationSkillComments;
}
