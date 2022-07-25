package com.example.springsecuritydemo.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestPayload {
    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private float price;
}
