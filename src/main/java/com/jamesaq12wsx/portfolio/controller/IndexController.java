package com.jamesaq12wsx.portfolio.controller;

import com.jamesaq12wsx.portfolio.exception.PdfNotFoundException;
import com.jamesaq12wsx.portfolio.exception.ResumeNotFoundException;
import com.jamesaq12wsx.portfolio.model.Resume;
import com.jamesaq12wsx.portfolio.model.ResumeLinkRecord;
import com.jamesaq12wsx.portfolio.service.ResumeLinkRecordService;
import com.jamesaq12wsx.portfolio.service.ResumeService;
import lombok.Getter;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.io.InputStream;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping("portfolio")
public class IndexController {

    private ResumeService resumeService;

    private ResumeLinkRecordService resumeLinkRecordService;

    @Autowired
    public IndexController(ResumeService resumeService, ResumeLinkRecordService resumeLinkRecordService) {
        this.resumeService = resumeService;
        this.resumeLinkRecordService = resumeLinkRecordService;
    }

    @GetMapping
    public String index(@RequestParam(name = "username") String username, @RequestParam(name = "company") String company, Model model){

        if (company == null || company.isEmpty()){
            company = "Other";
        }

        try{
            Resume usernameResume = resumeService.getResumeByUsername(username);
            model.addAttribute("resume", usernameResume);

            CompletableFuture future = CompletableFuture.runAsync(() -> {
                try{
                    resumeLinkRecordService.addRecord("");
                }catch (Exception e){
                    e.printStackTrace();
                }
            });

            return "index";
        }catch (ResumeNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resume Not Found", ex);
        }

    }

    @GetMapping(value = "/pdf/{username}", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] getPdf(@PathVariable("username") String username){
        try{
            Resource resource = new ClassPathResource(String.format("%s.pdf", username));
            InputStream input = resource.getInputStream();
            return input.readAllBytes();

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PDF resume not found", e);
        }
    }
}
