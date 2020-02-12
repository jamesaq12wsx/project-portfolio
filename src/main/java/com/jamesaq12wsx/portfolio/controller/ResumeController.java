package com.jamesaq12wsx.portfolio.controller;

import com.jamesaq12wsx.portfolio.exception.ResumeNotFoundException;
import com.jamesaq12wsx.portfolio.model.Resume;
import com.jamesaq12wsx.portfolio.model.User;
import com.jamesaq12wsx.portfolio.repository.ResumeRepository;
import com.jamesaq12wsx.portfolio.service.ResumeService;
import com.jamesaq12wsx.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/resume")
@RestController
public class ResumeController {

    private ResumeService resumeService;

    private UserService userService;

    @Autowired
    public ResumeController(ResumeService resumeService, UserService userService) {
        this.resumeService = resumeService;
        this.userService = userService;
    }

    @GetMapping
    public List<Resume> getAllResumes(){
        List<Resume> resumes = resumeService.getAllResume();
        return resumes;
    }

    @GetMapping("{username}")
    public ResponseEntity<Resume> getResumeByUsername(@PathVariable("username") String username){
        try{
            return ResponseEntity.ok().body(resumeService.getResumeByUsername(username));
        } catch (ResumeNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{userId}")
    public Resume addResume(@PathVariable("userId") UUID userId,@RequestBody Resume resume){
        return resumeService.addResume(userId, resume);
    }

    @PutMapping("{resumeId}")
    public Resume updateResume(@PathVariable("resumeId") UUID resumeId, @RequestBody Resume resume) throws ResumeNotFoundException {
        return resumeService.updateResume(resumeId, resume);
    }

    @DeleteMapping("{resumeId}")
    public void deleteResume(@PathVariable("resumeId") UUID resumeId){

    }


}
