package com.belong.phone.registry.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneRecord {

    Long phoneNumber;
    String customerId;
    boolean activationStatus;

}
