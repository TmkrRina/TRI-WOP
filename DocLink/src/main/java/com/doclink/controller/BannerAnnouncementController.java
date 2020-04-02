package com.doclink.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.doclink.dto.BannerAnnouncementDTO;
import com.doclink.exception.FormErrorsException;
import com.doclink.model.Post;
import com.doclink.service.BannerAnnouncementService;

@RestController
public class BannerAnnouncementController {
	@Autowired
	BannerAnnouncementService bannerAnnoucementService;

	@PostMapping("/api/users/{id}/posts")
	public @ResponseBody BannerAnnouncementDTO create(@Valid @RequestBody Post post, BindingResult result,
			WebRequest request, Errors errors,@PathVariable("id") Long id) throws Exception, FormErrorsException {
		if (result.hasErrors()) {
			throw new FormErrorsException(errors);
		} else {

			post = bannerAnnoucementService.creatPost(post, id);
			// eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user,
			// request.getLocale(), request.getContextPath()));
		}
		return new BannerAnnouncementDTO(post);
	}

}
