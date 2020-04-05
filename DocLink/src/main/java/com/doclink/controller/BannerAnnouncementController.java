package com.doclink.controller;

import javax.validation.Valid;

import com.doclink.model.BannerAnnouncement;
import com.doclink.repositories.BannerAnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.doclink.exception.FormErrorsException;
import com.doclink.service.BannerAnnouncementService;


@RestController
public class BannerAnnouncementController {
	@Autowired
	BannerAnnouncementService bannerAnnoucementService;

	@Autowired
	BannerAnnouncementRepo bannerAnnouncementRepo;

	@PostMapping("/api/admin/{id}/banner-announcements")
	public BannerAnnouncement create(
			@Valid @RequestBody BannerAnnouncement bannerAnnouncement,
			BindingResult result,
			Errors errors,
			@PathVariable("id") Long id
	) throws FormErrorsException {
		if (result.hasErrors()) {
			throw new FormErrorsException(errors);
		} else {

			bannerAnnouncement = bannerAnnoucementService.create(bannerAnnouncement, id);
			// eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user,
			// request.getLocale(), request.getContextPath()));
		}
		return bannerAnnouncement;
	}

	@GetMapping("/api/banner-announcements") // public endpoint
	public Iterable<BannerAnnouncement> getAll() {
		return bannerAnnouncementRepo.findAll();
	}

}
