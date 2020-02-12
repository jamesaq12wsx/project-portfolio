package com.jamesaq12wsx.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
public class User extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String password;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "default_resume",referencedColumnName = "resume_id")
//    @JsonIgnore
//    private Resume defaultResume;

}
