package com.belong.phone.registry.service;



import com.belong.phone.registry.model.PhoneRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PhoneService {

    public List<Long> getPhoneNumbers(String custId){
            log.info("Artist search initiated......");
            if(StringUtils.isEmpty(custId))
                return PhoneRecord.getAllPhoneRecords().stream().map(PhoneRecord::getPhoneNumber).collect(Collectors.toList());
            else
                return PhoneRecord.getAllPhoneRecords().stream().filter(record -> record.getCustomerId().equalsIgnoreCase(custId))
                        .map(PhoneRecord::getPhoneNumber).collect(Collectors.toList());
    }


    public void activatePhoneNumber(Long phoneNumber, boolean status){
        log.info("Artist search initiated......");
        PhoneRecord.getAllPhoneRecords().stream().filter(record -> record.getPhoneNumber()== phoneNumber)
                .forEach(a -> a.setActivationStatus(status));

    }

}
