package com.belong.phone.registry.service;

import com.belong.phone.registry.model.PhoneRecord;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@Slf4j
public class PhoneServiceTest {

    @InjectMocks
    PhoneService phoneService;

    public static List<PhoneRecord> records ;

    @Before
    public void setUp(){
        records = new ArrayList<>();
        records.add(new PhoneRecord(123456l, "C001", true));
        records.add(new PhoneRecord(123457l, "C002", false));
        records.add(new PhoneRecord(123458l,"C003", true));

        records.add(new PhoneRecord(123459l,"C004", true));

        records.add(new PhoneRecord(123460l,"C001", false));

        records.add(new PhoneRecord(123461l,"C002", true));

        records.add(new PhoneRecord(123462l,"C006", false));

    }

    @Test
    public void testGetAllPhoneNumbers(){
        assertEquals(records.size(), phoneService.getPhoneNumbers("").size());
        assertTrue(records.stream().map(PhoneRecord::getPhoneNumber).collect(Collectors.toList()).equals(phoneService.getPhoneNumbers("")));
    }

    @Test
    public void testGetPhoneNumberFoCustomer(){
        assertEquals(2, phoneService.getPhoneNumbers("C001").size());
    }

    @Test
    public void testActivatePhoneNumber(){
        phoneService.activatePhoneNumber(123457l, true);
        assertTrue(phoneService.getAllNumbers().stream().filter(a -> a.getPhoneNumber()==123459l)
                .collect(Collectors.toList()).get(0).isActivationStatus());
    }

}
