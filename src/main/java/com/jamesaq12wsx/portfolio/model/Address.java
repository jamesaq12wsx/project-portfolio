package com.jamesaq12wsx.portfolio.model;



import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
public class Address implements Serializable {

    @NotNull
    @Size(max = 1000)
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    @Size(max = 1000)
    private String country;

    @NotNull
    private String zipCode;

    public Address() { }
}
