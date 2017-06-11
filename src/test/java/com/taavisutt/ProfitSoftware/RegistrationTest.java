package com.taavisutt.ProfitSoftware;

import com.taavisutt.ProfitSoftware.registration.Registration;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Taavi on 09.06.2017.
 */
public class RegistrationTest {

    private Registration registration;

    @Before
    public void setUp() {
        registration = new Registration();
    }
    @Test
    public void testSetId() {
        registration.setId(1);
        assertEquals(1, registration.getId());
    }
    @Test
    public void testSetFirstName(){
        registration.setFirstName("Taavi");
        assertEquals("Taavi", registration.getFirstName());
    }
    @Test
    public void testSetLastName() {
        registration.setLastName("Sutt");
        assertEquals("Sutt",registration.getLastName());
    }
    @Test
    public void testSetUsername(){
        registration.setUsername("User1");
        assertEquals("User1" ,registration.getUsername());
    }
    @Test
    public void testSetPassword() {
        registration.setPassword("12AbCdE34");
        assertEquals("12AbCdE34", registration.getPassword());
    }




}
