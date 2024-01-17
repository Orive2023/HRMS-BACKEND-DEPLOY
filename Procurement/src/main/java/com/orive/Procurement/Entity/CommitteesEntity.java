package com.orive.Procurement.Entity;

import com.orive.Procurement.Config.AesEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "committees")
public class CommitteesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long committeesId;
	
	@Column(name = "name")
	@Convert(converter = AesEncryptor.class)
	private String name;
	
	@Lob
	@Column(name = "signature", length = 100000)
	private byte[] signature;

}
