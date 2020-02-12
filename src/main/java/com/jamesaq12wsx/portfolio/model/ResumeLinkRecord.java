package com.jamesaq12wsx.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "link_record")
@NotNull
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResumeLinkRecord extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull(message = "Link could not be null")
    @Column(name = "company_param")
    private String companyParam;

    public ResumeLinkRecord(String companyParam){
        this();
        this.companyParam = companyParam;
    }

}
