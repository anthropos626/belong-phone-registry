package com.belong.phone.registry.controller;


import com.belong.phone.registry.service.PhoneService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class PhoneController {

    @Autowired
    PhoneService phoneService;

    @ApiOperation(value = "getArtistDetails", notes = "The API returns artist suggestions if multiple matches or releases if only one match", nickname = "artistSearch")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "Successful retrieval", responseContainer = "List")})
    @GetMapping("/phonenumbers")
    public List<Long> getPhoneNumbers(@ApiParam(value = "search keyword for name of the artist",
            required = true, example = "Sheeran") @RequestParam(required = false) String custId) {
        return phoneService.getPhoneNumbers(custId);
    }

    @GetMapping("/phonenumbers/{number}")
    public void activatePhoneNumber(@ApiParam(value = "search keyword for name of the artist",
            required = true, example = "Sheeran") @RequestParam boolean status, @PathVariable Long number) {
         phoneService.activatePhoneNumber(number , status);
    }

}
