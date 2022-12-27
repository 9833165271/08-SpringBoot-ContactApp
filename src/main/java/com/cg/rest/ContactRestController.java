package com.cg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.binding.ContactForm;
import com.cg.service.ContactService;

import io.swagger.annotations.Api;

@Api(description = "This is for Products operations")
@RestController
public class ContactRestController {

	@Autowired
	private ContactService service;

	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {
		System.out.println(form);
		String status = service.saveContact(form);
		return status;
	}

	@GetMapping("/contacts")
	public List<ContactForm> viewAllContacts() {
		return service.viewContacts();
	}
	
	@GetMapping("/edit/{contactId}")
	public  ContactForm editContact(@PathVariable Integer contactId) {
		return service.editContact(contactId);
	}
	
	@DeleteMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId){
		return service.deleteContact(contactId);
		//return service.viewContacts();
	}

}
