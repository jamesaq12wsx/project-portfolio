package com.jamesaq12wsx.portfolio.dao;

import com.jamesaq12wsx.portfolio.model.Resume;

import java.util.UUID;

public interface ResumeDao {

    Resume getResumeById(UUID id);

}
