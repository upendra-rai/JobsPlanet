package com.gsu.app.jobsplanet.service;

import java.util.List;
import java.util.Optional;

import com.gsu.app.jobsplanet.entity.ContactUs;

public interface ContactUsService {
	public ContactUs createContactUs(ContactUs ContactUs);
	public ContactUs updateContactUs(ContactUs ContactUs);
	public Optional<ContactUs> getContactUsById(long ContactUsId);
	public void deleteContactUs(long ContactUsId);
	public List<ContactUs> getAllContactUsList();
}
