package com.orive.Employee.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.orive.Employee.Dto.PromotionsDto;
import com.orive.Employee.Dto.TransfersDto;
import com.orive.Employee.Dto.TravelsDto;
import com.orive.Employee.Entity.PromotionsEntity;
import com.orive.Employee.Entity.TransfersEntity;
import com.orive.Employee.Entity.TravelsEntity;
import com.orive.Employee.Repository.PromotionsRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class PromotionsService {
	
	private static final Logger logger=LoggerFactory.getLogger(PromotionsService.class);
	
	@Autowired
	private PromotionsRepository promotionsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	// Create
	public PromotionsDto createPromotions(PromotionsDto promotionsDto) {
	    PromotionsEntity promotionsEntity = convertToEntity(promotionsDto);

	    PromotionsEntity savedPromotions = promotionsRepository.save(promotionsEntity);
	    logger.info("Created promotions with ID: {}", savedPromotions.getPromotionsId());

	    // Send email with the generated token
	    sendPromotionEmail(savedPromotions);

	    return convertToDTO(savedPromotions);
	}

    // Read
    public List<PromotionsDto> getAllPromotions() {
        List<PromotionsEntity> PromotionsEntities = promotionsRepository.findAll();
        logger.info("Retrieved {} Promotions from the database", PromotionsEntities.size());
        return PromotionsEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by PpromotionsId
    public Optional<PromotionsDto> getPromotionsById(Long promotionsId) {
        Optional<PromotionsEntity> promotions = promotionsRepository.findById(promotionsId);
        if (promotions.isPresent()) {
            return Optional.of(convertToDTO(promotions.get()));
        } else {
            logger.warn("Promotions with ID {} not found", promotionsId);
            return Optional.empty();
        }
    }
    
    //get promotion details by username
    public List<PromotionsDto> getPromotionsByUsername(String username) {
        List<PromotionsEntity> transfersEntities = promotionsRepository.findByUsername(username);
        return transfersEntities.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
 // Update list by id
    public PromotionsDto updatePromotions(Long promotionsId, PromotionsDto promotionsDto) {
        Optional<PromotionsEntity> existingPromotionsOptional = promotionsRepository.findById(promotionsId);
        if (existingPromotionsOptional.isPresent()) {
        	PromotionsEntity existingPromotions = existingPromotionsOptional.get();
        	existingPromotions.setEmployeeName(promotionsDto.getEmployeeName());
        	existingPromotions.setPromotionTitle(promotionsDto.getPromotionTitle());
        	existingPromotions.setPromotionDate(promotionsDto.getPromotionDate());
            modelMapper.map(promotionsDto, existingPromotionsOptional);
            PromotionsEntity updatedPromotions = promotionsRepository.save(existingPromotions);
            logger.info("Updated Promotions with ID: {}", updatedPromotions.getPromotionsId());
            return convertToDTO(updatedPromotions);
        } else {
            logger.warn("Promotions with ID {} not found for update", promotionsId);
            return null;
        }
    }
    
    // Delete
    public void deletePromotions(Long promotionsId) {
    	promotionsRepository.deleteById(promotionsId);
        logger.info("Deleted Promotions with ID: {}", promotionsId);
    }

    //count the total Promotions
    public long countPromotions()
	 {
		 return promotionsRepository.count();
	 }
    
    
    private void sendPromotionEmail(PromotionsEntity promotionEntity) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(promotionEntity.getEmail());
            helper.setSubject("Promotion Offer - Congratulations " + promotionEntity.getEmployeeName() + "!");

            String emailContent = "Dear " + promotionEntity.getEmployeeName() + ",\n\n"
                    + "I am delighted to inform you that, after careful consideration of your performance, dedication, and contributions to [Company Name], we are pleased to offer you a well-deserved promotion to the position of "
                    + promotionEntity.getPromotionTitle() + ".\n\n"
                    + "Your hard work, commitment to excellence, and positive attitude have not gone unnoticed. You have consistently demonstrated exceptional skills and professionalism in your role as [Current Position/Title], and we believe that this promotion is a testament to your capabilities and potential within our organization.\n\n"
                    + "Starting from " + promotionEntity.getPromotionDate().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")) + ", you will assume the responsibilities of " + promotionEntity.getDescription() + ". We are confident that you will excel in this new capacity and continue to make valuable contributions to the success of our team and the company as a whole.\n\n"
                    + "With this promotion comes an adjusted compensation package, which includes [Details of salary increase, bonuses, benefits changes, etc.]. You will receive a detailed breakdown of your new compensation and benefits from the HR department.\n\n"
                    + "We are also excited to support your continued growth and development within [Company Name]. As part of your promotion, you will have access to [Mention any additional training, mentorship programs, or other resources available].\n\n"
                    + "Please indicate your acceptance of this promotion by signing and returning the attached promotion acceptance form by [Acceptance Deadline Date]. If you have any questions or need further clarification about your new role or compensation, please do not hesitate to contact me or the HR department.\n\n"
                    + "Once again, congratulations on your well-deserved promotion! We look forward to witnessing your continued success and achievements as a valuable member of our team.\n\n"
                    + "Best regards,\n\n"
                    + "[Your Name]";

            helper.setText(emailContent);

            javaMailSender.send(message);
        } catch (MessagingException | MailException e) {
            // Handle exception
            e.printStackTrace();
            // You might want to throw an exception or log the error here
        }
    }
    
 // Helper method to convert PromotionsDTo to PromotionsEntity
    private PromotionsEntity convertToEntity(PromotionsDto promotionsDto)
    {
    	return modelMapper.map(promotionsDto, PromotionsEntity.class);
    }

    // Helper method to convert PromotionsEntity to PromotionsDTo
    private PromotionsDto convertToDTO(PromotionsEntity promotionsEntity) {
        return modelMapper.map(promotionsEntity, PromotionsDto.class);
    } 
}
