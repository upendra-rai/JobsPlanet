package com.gsu.app.jobsplanet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsu.app.jobsplanet.entity.ContactUs;
import com.gsu.app.jobsplanet.repository.ContactUsRepository;

@Service
public class ContactUsServiceImpl implements ContactUsService {

	@Autowired ContactUsRepository ContactUsRepository;
	
	@Override
	public ContactUs createContactUs(ContactUs ContactUs) {
		return ContactUsRepository.save(ContactUs);
	}

	@Override
	public ContactUs updateContactUs(ContactUs ContactUs) {
		return ContactUsRepository.save(ContactUs);
	}

	@Override
	public Optional<ContactUs> getContactUsById(long ContactUsId) {
		return ContactUsRepository.findById(ContactUsId);
	}

	@Override
	public void deleteContactUs(long ContactUsId) {
		ContactUsRepository.deleteById(ContactUsId);
	}

	@Override
	public List<ContactUs> getAllContactUsList() {
		return ContactUsRepository.findAll();
		
	}

}
