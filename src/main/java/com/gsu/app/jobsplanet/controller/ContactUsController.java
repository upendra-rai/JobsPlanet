package com.gsu.app.jobsplanet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gsu.app.jobsplanet.entity.ContactUs;
import com.gsu.app.jobsplanet.exception.ResourceNotFoundException;
import com.gsu.app.jobsplanet.service.ContactUsService;

@RestController
@RequestMapping("/contactus")
public class ContactUsController {

	@Autowired
	private ContactUsService ContactUsService;

	@PostMapping("/create")
	public ContactUs createContactUs(@RequestBody ContactUs ContactUs) {
		return ContactUsService.createContactUs(ContactUs);
	}

	@PostMapping("/update")
	public ContactUs updateContactUs(@RequestBody ContactUs ContactUs) {
		return ContactUsService.updateContactUs(ContactUs);
	}

	@GetMapping("/getById")
	public Optional<ContactUs> getContactUsById(@RequestParam("id") Long ContactUsId) throws ResourceNotFoundException {
		Optional<ContactUs> ContactUs = ContactUsService.getContactUsById(ContactUsId);
		if (ContactUs == null) {
			throw new ResourceNotFoundException();
		}
		return ContactUsService.getContactUsById(ContactUsId);
	}

	@GetMapping("/getAll")
	public List<ContactUs> getallContactUs() {
		return ContactUsService.getAllContactUsList();
	}

	@DeleteMapping("/deletebyId/{id}")
	public void deleteContactUs(@PathVariable("id") Long ContactUs) {
		ContactUsService.deleteContactUs(ContactUs);
	}

}
