package com.taavisutt.ProfitSoftware.dao;

import com.taavisutt.ProfitSoftware.dao.entity.RegistrationEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RegistrationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(RegistrationEntity registration)  {
        entityManager.persist(registration);
    }

    public List<RegistrationEntity> getAllRegistrations() {
        return entityManager.createQuery("SELECT e FROM RegistrationEntity e").getResultList();
    }

    public void deleteRegistration(long parameter) {
        entityManager.createQuery("DELETE From RegistrationEntity WHERE ID="+ parameter).executeUpdate();
    }

    public void updateRegistration(long id, String firstName, String lastName, String username, String password ) {
        entityManager.createQuery("UPDATE RegistrationEntity SET " +
                "FIRST_NAME=" + "'" + firstName + "', " +
                "LASTNAME=" +"'" + lastName + "', " +
                "PASSWORD=" +"'" + password + "', " +
                "USERNAME=" + "'" + username + "' " +
                "WHERE ID="+ id).executeUpdate();
    }






}