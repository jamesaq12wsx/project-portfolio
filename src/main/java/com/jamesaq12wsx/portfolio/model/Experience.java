package com.jamesaq12wsx.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Experience implements Serializable {

    @Column(name = "current_job")
    private boolean currentJob;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    @NotNull
    @Column(name = "end_date")
    private Date endDate;

    @NotNull
    private String company;

    @Column(name = "company_url", columnDefinition="varchar(1000) default ''")
    private String companyUrl;

    @NotNull
    private String role;

    @Column(name = "comment", columnDefinition = "varchar(3000) default ''")
    private String comment;
}
