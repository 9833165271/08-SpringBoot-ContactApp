package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.binding.ContactForm;
import com.cg.entity.Contact;
import com.cg.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public String saveContact(ContactForm form) {
		//we have received form binding object as parameter 
		//Repository save(entity) method  expecting entity object 
		//so we need to copy the data from binding object to entity object
		Contact entity = new Contact();
		BeanUtils.copyProperties(form, entity);
		
		entity = contactRepo.save(entity);
		if(entity.getContactId() !=null) {
			return "success";
		}
		return "fail";
	}

	@Override
	public List<ContactForm> viewContacts() {
		List<ContactForm>dataList = new ArrayList<>();
		List<Contact>findAll=contactRepo.findAll();
		for(Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
			return dataList;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		 Optional<Contact> findById = contactRepo.findById(contactId);
		 if(findById.isPresent()) {
			 Contact entity = findById.get();
			 ContactForm form = new ContactForm();
			 BeanUtils.copyProperties(entity, form);
			 return form;
			 
		 }
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		contactRepo.deleteById(contactId);
		//return viewContacts(); we can use this also to get latest record or below option
		
		//Getting latest data from table and returning 
		List<ContactForm>dataList = new ArrayList<>();
		List<Contact>findAll=contactRepo.findAll();
		for(Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
			return dataList;
	}

}
