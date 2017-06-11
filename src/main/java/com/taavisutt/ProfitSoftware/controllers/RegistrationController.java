package com.taavisutt.ProfitSoftware.controllers;

import com.taavisutt.ProfitSoftware.dao.entity.RegistrationEntity;
import com.taavisutt.ProfitSoftware.registration.Registration;
import com.taavisutt.ProfitSoftware.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Taavi on 02.06.2017.
 */
@RestController

public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "createRegistration", method = RequestMethod.POST)
    public void createRegistration(@RequestBody Registration request) {
        System.out.println(request.getLastName());
        registrationService.addRegistration(request.getFirstName(),
                request.getLastName(),
                request.getDateOfBirth(),
                request.getUsername(),
                request.getPassword());

    }

    @RequestMapping(value = "registrations", method = RequestMethod.GET)
    public List<RegistrationEntity> registrations() {
        return registrationService.listVisits();
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public void delete(@RequestBody Registration request) {
        registrationService.deleteRegistration(request.getId());
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(@RequestBody Registration request) {
        registrationService.updateRegistration(
                request.getId(),
                request.getFirstName(),
                request.getLastName(),
                request.getUsername(),
                request.getPassword()
        );
    }


}
