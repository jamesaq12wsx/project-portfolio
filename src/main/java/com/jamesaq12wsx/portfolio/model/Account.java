package com.jamesaq12wsx.portfolio.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Account {

    private String uuid;

    private String email;

    private String username;

    private String password;

    private String defaultResume;

    private List<String> resumes;

}
