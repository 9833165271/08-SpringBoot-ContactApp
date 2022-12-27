package com.cg.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContactForm {
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private String activeSw;
	private LocalDate createDate;
	private LocalDate updatedDate;
}
