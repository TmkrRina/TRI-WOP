package com.doclink.controller;

import com.doclink.exception.FormErrorsException;
import com.doclink.exception.ResourceNotFoundException;
import com.doclink.model.Announcement;
import com.doclink.repositories.AnnouncementRepo;
import com.doclink.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AnnouncementsController {
    @Autowired
    AnnouncementService announcementService;

    @Autowired
    AnnouncementRepo announcementRepo;


    @PostMapping("/api/doctors/{id}/announcements")
    public @ResponseBody Announcement create(@Valid @RequestBody Announcement announcement, BindingResult result, Errors errors, @PathVariable("id") Long id) throws Exception, FormErrorsException {
        if (result.hasErrors()) {
            throw new FormErrorsException(errors);
        } else {

            announcement = announcementService.create(announcement, id);
            // eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user,
            // request.getLocale(), request.getContextPath()));
        }
        return announcement;
    }

    @GetMapping("/api/announcements")
    public @ResponseBody
    Iterable<Announcement> getAll() {
        return announcementRepo.findAll();
    }

    @PostMapping("/api/users/announcements/{id}")
    public @ResponseBody Announcement getAnnouncement(@PathVariable("id") Long id) {
        return announcementRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found", "id", id));
    }


}
