package com.example.Authentication;


import com.example.Authentication.entities.User;
import com.example.Authentication.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;




@DataJpaTest

public class UserServiceTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserService userservice;

    @BeforeEach
    public void initAll() {
        entityManager.persist(new User("Dummy","test@test.com","password"));
        entityManager.persist(new User("Dummy2","test2@test.com","password2"));
        entityManager.persist(new User("Dummy3","test3@test.com","password3"));
        entityManager.persist(new User("Dummy4","test4@test.com","password4"));
        entityManager.flush();
    }
    @Test
    public void whenGetUserByName_thenReturnUser() {
        // when
        User found = userservice.GetUserByName("Dummy");
        // then
        assertEquals(found.getName(), "Dummy");
        assertNotEquals(found.getName(),"Dummy2");
    }
    
    @Test
    public void whenAuthenticate_thenReturnUser() {
    	//when
    	User found = userservice.Authenticate("Dummy3","password3");
    	User notFound = userservice.Authenticate("Dummy2","password");
    	User notFound2= userservice.Authenticate("Dummy5","password");
    	//then
    	assertEquals(found,userservice.GetUserByName("Dummy3"));
    	assertEquals(notFound,null);
    	assertEquals(notFound2,null);
    	
    }

}