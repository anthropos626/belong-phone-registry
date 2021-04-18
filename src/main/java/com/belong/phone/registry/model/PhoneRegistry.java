package com.belong.phone.registry.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneRegistry {

    public static List<PhoneRecord> records = new ArrayList<>();

    static{

        records.add(new PhoneRecord(123456l, "C001", true));
        records.add(new PhoneRecord(123457l, "C002", false));
        records.add(new PhoneRecord(123458l,"C003", true));

        records.add(new PhoneRecord(123459l,"C004", true));

        records.add(new PhoneRecord(123460l,"C001", false));

        records.add(new PhoneRecord(123461l,"C002", true));

        records.add(new PhoneRecord(123462l,"C006", false));

    }



    public static List<PhoneRecord> getAllPhoneRecords() {
        return records;
    }
}
