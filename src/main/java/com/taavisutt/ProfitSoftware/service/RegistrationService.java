package com.taavisutt.ProfitSoftware.service;

import com.taavisutt.ProfitSoftware.dao.RegistrationDao;
import com.taavisutt.ProfitSoftware.dao.entity.RegistrationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Taavi on 02.06.2017.
 */
@Service
@Transactional
public class RegistrationService {

    @Autowired
    private RegistrationDao registrationDao;

    public void addRegistration(String firstName, String lastName, Date dateOfBirth, String username, String password) {
        //System.out.println("Olen reg Services" + firstName + lastName + dateOfBirth + username +password);
        RegistrationEntity registration = new RegistrationEntity(firstName, lastName, dateOfBirth, username, password);
        registrationDao.create(registration);
    }

    public List<RegistrationEntity> listVisits () {
        return registrationDao.getAllRegistrations();
    }

    public void deleteRegistration(long parameter) {
        registrationDao.deleteRegistration(parameter);

    }

    public void updateRegistration(long id, String firstName, String lastName,  String username, String password) {
        registrationDao.updateRegistration(id, firstName, lastName, username, password);

    }



}
