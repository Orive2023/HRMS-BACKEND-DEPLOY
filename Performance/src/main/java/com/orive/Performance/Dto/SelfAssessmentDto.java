package com.orive.Performance.Dto;


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
public class SelfAssessmentDto {

    private Long selfAssessmentId;
	private int performanceGoalRating;
	private String performanceGoalComments;
	private int newSkillsRating;
	private String newSkillsComments;
	private int collaborationRating;
	private String collaborationComments;
	private int managedYourTimeRating;
	private String managedYourTimeComments;
	private int improvedCommunicationSkillRating;
	private String improvedCommunicationSkillComments;
}
