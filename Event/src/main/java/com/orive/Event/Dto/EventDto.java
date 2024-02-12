package com.orive.Event.Dto;

import com.orive.Event.Entity.EventEntity;
import com.orive.Event.Enum.Status;

import jakarta.persistence.Column;
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
public class EventDto {

    private String eventId;
	private String date;
	private String title;
	private String className;
	private String status;
}
