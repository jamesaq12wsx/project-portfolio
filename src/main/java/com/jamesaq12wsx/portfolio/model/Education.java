package com.jamesaq12wsx.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Education implements Serializable {

    @NotNull
    private String institute;

    @Column(name = "link")
    private String link;

    @NotNull
    private String program;

    @NotNull
    private String major;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    @NotNull
    @Column(name = "end_date")
    private Date endDate;

    @Size(max = 3000)
    private String comment;

}
