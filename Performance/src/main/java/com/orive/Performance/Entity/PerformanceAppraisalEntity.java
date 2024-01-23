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
@Table(name = "performanceappraisal")
public class PerformanceAppraisalEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom-sequence")
    @GenericGenerator(name = "custom-sequence", strategy = "com.orive.Performance.Entity.PerformanceAppraisalCustomIdGenerator")
	private String performanceAppraisalId;
	
	@Column(name = "employee_name")
	@Convert(converter = AesEncryptor.class)
	private String employeeName;
	
	@Column(name = "employee_id")
	@Convert(converter = AesEncryptor.class)
	private Long employeeId;
	
	@Column(name = "department_name")
	@Convert(converter = AesEncryptor.class)
	private String departmentName;
		
	@Column(name = "position")
	@Convert(converter = AesEncryptor.class)
	private String position;
	
	@Column(name = "appraisal_period")
	@Convert(converter = AesEncryptor.class)
	private LocalDate appraisalPeriod;
	
	@Column(name = "quality_of_work_rating")
	@Convert(converter = AesEncryptor.class)
	private int qualityOfWorkRating;
	
	@Column(name = "quality_of_work_comments")
	@Convert(converter = AesEncryptor.class)
	private String qualityOfWorkComments;
	
	@Column(name = "quality_of_work_score")
	@Convert(converter = AesEncryptor.class)
	private Long qualityOfWorkScore;
	
	@Column(name = "job_knowledge_rating")
	@Convert(converter = AesEncryptor.class)
	private int jobKnowledgeRating;
	
	@Column(name = "job_knowledge_comments")
	@Convert(converter = AesEncryptor.class)
	private String jobKnowledgeComments;
	
	@Column(name = "job_knowledge_score")
	@Convert(converter = AesEncryptor.class)
	private Long jobKnowledgeScore;
	
	@Column(name = "communication_skills_rating")
	@Convert(converter = AesEncryptor.class)
	private int communicationSkillsRating;

	@Column(name = "communication_skills_comments")
	@Convert(converter = AesEncryptor.class)
	private String communicationSkillsComments;
	
	@Column(name = "communication_skills_score")
	@Convert(converter = AesEncryptor.class)
	private Long communicationSkillsScore;
	
	@Column(name = "teamwork_and_collaboration_rating")
	@Convert(converter = AesEncryptor.class)
	private int teamworkAndCollaborationRating;
	
	@Column(name = "teamwork_and_collaboration_comments")
	@Convert(converter = AesEncryptor.class)
	private String teamworkAndCollaborationComments;
	
	@Column(name = "teamwork_and_collaboration_score")
	@Convert(converter = AesEncryptor.class)
	private Long teamworkAndCollaborationScore;
	
	@Column(name = "initiative_and_creativity_rating")
	@Convert(converter = AesEncryptor.class)
	private int initiativeAndCreativityRating;
	
	@Column(name = "initiative_and_creativity_comments")
	@Convert(converter = AesEncryptor.class)
	private String initiativeAndCreativityComments;
	
	@Column(name = "initiative_and_creativity_score")
	@Convert(converter = AesEncryptor.class)
	private Long initiativeAndCreativityScore;
	
	@Column(name = "punctuality_and_attendance_rating")
	@Convert(converter = AesEncryptor.class)
	private int punctualityAndAttendanceRating;
	
	@Column(name = "punctuality_and_attendance_comments")
	@Convert(converter = AesEncryptor.class)
	private String punctualityAndAttendanceComments;
	
	@Column(name = "punctuality_and_attendance_score")
	@Convert(converter = AesEncryptor.class)
	private Long punctualityAndAttendanceScore;
	
	@Column(name = "adaptability_rating")
	@Convert(converter = AesEncryptor.class)
	private int adaptabilityRating;
	
	@Column(name = "adaptability_comments")
	@Convert(converter = AesEncryptor.class)
	private String adaptabilityComments;
	
	@Column(name = "adaptability_score")
	@Convert(converter = AesEncryptor.class)
	private Long adaptabilityScore;
	
	@Column(name = "overall_rating")
	@Convert(converter = AesEncryptor.class)
	private int overallRating;
	
	@Column(name = "overall_comments")
	@Convert(converter = AesEncryptor.class)
	private String overallComments;
	
	@Column(name = "overall_score")
	@Convert(converter = AesEncryptor.class)
	private Long overallScore;
	
	@Column(name = "areas_for_improvement")
	@Convert(converter = AesEncryptor.class)
	private String areasForImprovement;
	
	@Column(name = "employees_self_assessment")
	@Convert(converter = AesEncryptor.class)
	private String employeesSelfAssessment;
	
	@Column(name = "goals_achieved")
	@Convert(converter = AesEncryptor.class)
	private String goalsAchieved;
	
	@Column(name = "development_plan")
	@Convert(converter = AesEncryptor.class)
	private String developmentPlan;
	
	@Column(name = "managers_comments")
	@Convert(converter = AesEncryptor.class)
	private String managersComments;	
}
