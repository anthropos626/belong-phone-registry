package com.belong.phone.registry.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneRecord {

    Long phoneNumber;
    String customerId;
    boolean activationStatus;


    public static List<PhoneRecord> getAllPhoneRecords() {

        List<PhoneRecord> records = new ArrayList<>();
        records.add(new PhoneRecord(123456l, "C001", true));
        records.add(new PhoneRecord(123457l, "C002", false));
        records.add(new PhoneRecord(123458l,"C003", true));

        records.add(new PhoneRecord(123459l,"C004", true));

        records.add(new PhoneRecord(123460l,"C001", false));

        records.add(new PhoneRecord(123461l,"C002", true));

        records.add(new PhoneRecord(123462l,"C006", false));

        return records;
    }
}
