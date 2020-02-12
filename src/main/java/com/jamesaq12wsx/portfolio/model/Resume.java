package com.jamesaq12wsx.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jamesaq12wsx.portfolio.helper.StringListConverter;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "resume")
public class Resume extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "resume_id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @NotNull(message = "First name may not be blank")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last name may not be blank")
    @Column(name = "last_name")
    private String lastName;

    private String statement;

    @NotNull(message = "Phone may not be blank")
    private String phone;

    private String email;

    @Embedded
    private Address address;

    @Column(name = "`default`")
    private boolean isDefault;

    @ElementCollection
    @CollectionTable(
            name = "resume_social_link",
            joinColumns = @JoinColumn(name = "resume_id")
    )
    private Set<SocialLink> socialLinks;

    @ElementCollection
    @CollectionTable(
            name = "resume_experience",
            joinColumns = @JoinColumn(name = "resume_id")
    )
    private List<Experience> experiences;

    @ElementCollection
    @CollectionTable(
            name = "resume_education",
            joinColumns = @JoinColumn(name = "resume_id")
    )
    private List<Education> educations;

    @Convert(converter = StringListConverter.class)
    private List<String> skills;

    @Column(name = "contact_comment")
    @Size(max = 5000)
    private String contactComment;

    @Column(name ="resume_url")
    @Size(max = 1000)
    private String resumeUrl;

}
