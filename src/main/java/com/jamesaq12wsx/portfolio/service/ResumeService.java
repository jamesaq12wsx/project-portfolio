package com.jamesaq12wsx.portfolio.service;

import com.jamesaq12wsx.portfolio.exception.ResumeNotFoundException;
import com.jamesaq12wsx.portfolio.model.Resume;
import com.jamesaq12wsx.portfolio.model.User;
import com.jamesaq12wsx.portfolio.repository.ResumeRepository;
import com.jamesaq12wsx.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ResumeService {

    private ResumeRepository resumeRepository;

    private UserRepository userRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository, UserRepository userRepository) {
        this.resumeRepository = resumeRepository;
        this.userRepository = userRepository;
    }

    public List<Resume> getAllResume(){
        return resumeRepository.findAll();
    }

    public Resume getResumeByUsername(String username) throws ResumeNotFoundException {

        try{
            Resume target = resumeRepository.findResumeByUsername(username).get();
            return target;
        }catch (Exception e){
            throw new ResumeNotFoundException(e);
        }

    }

    public Resume addResume(UUID userId, Resume resume){

        User targetUser = userRepository.findById(userId).orElse(null);

        if (targetUser == null){
            return null;
        }

        resume.setUser(targetUser);

        return resumeRepository.save(resume);
    }

//    public List<Resume> getResumesByUserId(UUID userId){
//        return resumeRepository.findByUserId(userId);
//    }

    public boolean deleteResumeById(UUID resumeId){
        try{
            this.resumeRepository.deleteById(resumeId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Resume updateResume(UUID resumeId, Resume resume) throws ResumeNotFoundException {

        Resume targetResume = resumeRepository.findById(resumeId).orElseGet(null);

        if (targetResume != null){
            resume.setId(targetResume.getId());
            resume.setUser(targetResume.getUser());
            resume.setCreatedAt(targetResume.getCreatedAt());

            return resumeRepository.save(resume);
        }else{
            throw new ResumeNotFoundException("Resume not found");
        }

    }
}
