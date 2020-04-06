package com.doclink.controller;

import com.doclink.exception.FormErrorsException;
import com.doclink.exception.ResourceNotFoundException;
import com.doclink.model.HealthIssue;
import com.doclink.repositories.HealthIssueRepo;
import com.doclink.repositories.UserRepo;
import com.doclink.service.AnnouncementService;
import com.doclink.service.HealthIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class HealthIssuesController {
	@Autowired
	HealthIssueService healthIssueService;

	@Autowired
	HealthIssueRepo healthIssueRepo;

	@Autowired
	UserRepo userRepo;


	@Autowired
	AnnouncementService announcementService;

	@PostMapping("/api/users/{id}/health-issues") // For a patient
	public @ResponseBody HealthIssue create(@Valid @RequestBody HealthIssue healthIssue, BindingResult result, Errors errors, @PathVariable("id") Long id) throws Exception, FormErrorsException {
		if (result.hasErrors()) {
			throw new FormErrorsException(errors);
		} else {

			healthIssue = healthIssueService.create(healthIssue, id);
			// eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user,
			// request.getLocale(), request.getContextPath()));
		}
		return healthIssue;
	}

	@PutMapping("/api/users/{id}/health-issues/{healthId}") // update for a patient
	public @ResponseBody HealthIssue update(@Valid @RequestBody HealthIssue healthIssue, BindingResult result, Errors errors, @PathVariable("id") Long id) throws Exception, FormErrorsException {
		if (result.hasErrors()) {
			throw new FormErrorsException(errors);
		} else {

			healthIssue = healthIssueService.update(healthIssue);
			// eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user,
			// request.getLocale(), request.getContextPath()));
		}
		return healthIssue;
	}

	@GetMapping("/api/doctors/health-issues") // for doctors
	public @ResponseBody Iterable<HealthIssue> healthIssues() {
		return healthIssueRepo.findAll();
	}


	@GetMapping("/api/users/{id}/health-issues/{healthIssueId}")
	public @ResponseBody HealthIssue getOne(@PathVariable("healthIssueId") Long healthIssueId) {
		return healthIssueRepo.findById(healthIssueId).orElseThrow(() -> new ResourceNotFoundException("Health issue not found", "Id", healthIssueId));
	}

	@GetMapping("/api/users/{id}/health-issues")
	public @ResponseBody Iterable<HealthIssue> getForUser(@PathVariable("id") Long id) {
		return healthIssueRepo.findByUserId(id);
	}
}
