package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
