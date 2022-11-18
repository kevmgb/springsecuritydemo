package com.example.springsecuritydemo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @JsonProperty("email")
    @Email
    @Length(min = 5, max = 50)
    private String email;

    @Length(min = 5, max = 10)
    @JsonProperty("password")
    private String password;
}
