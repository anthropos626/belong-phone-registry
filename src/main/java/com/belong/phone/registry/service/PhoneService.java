package com.belong.phone.registry.service;



import com.belong.phone.registry.model.PhoneRecord;
import com.belong.phone.registry.model.PhoneRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PhoneService {

    public List<Long> getPhoneNumbers(String custId){
            log.info("getting phone numbers......");
            if(StringUtils.isEmpty(custId))
                return getAllNumbers().stream().map(PhoneRecord::getPhoneNumber).collect(Collectors.toList());
            else
                return PhoneRegistry.getAllPhoneRecords().stream().filter(record -> record.getCustomerId().equalsIgnoreCase(custId))
                        .map(PhoneRecord::getPhoneNumber).collect(Collectors.toList());
    }


    public void activatePhoneNumber(Long phoneNumber, boolean status){
        log.info("getting phone numbers......");
        getAllNumbers().stream().filter(record -> record.getPhoneNumber()== phoneNumber)
                .forEach(a -> a.setActivationStatus(status));
    }

    public List<PhoneRecord> getAllNumbers(){
        return PhoneRegistry.getAllPhoneRecords();
    }

}
