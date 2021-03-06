package com.example.Authentication;


import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.Optional;



@DataJpaTest

public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void initAll() {
        entityManager.persist(new User("Dummy","test@test.com","password"));
        entityManager.persist(new User("Dummy2","test2@test.com","password2"));
        entityManager.persist(new User("Dummy3","test3@test.com","password3"));
        entityManager.persist(new User("Dummy4","test4@test.com","password4"));
        entityManager.flush();
    }
    @Test
    public void whenFindByName_thenReturnUser() {
        // when
        User found = userRepository.findByName("Dummy");
        User notFound = userRepository.findByName("Dummy5");
        // then
        assertEquals(found.getName(), "Dummy");
        assertNotEquals(found.getName(),"Dummy2");
        assertEquals(notFound,null);
    }
    
    @Test
    public void whenFindById_thenReturnUser() {
    	//when
    	Optional<User> found = userRepository.findById(3);
    	//then
    	Optional<User> notFound = userRepository.findById(6);
    	
    	assertEquals(found.get().getName(),"Dummy3");
    	assertEquals(found.get().getEmail(),"test3@test.com");
    	assertEquals(found.get().getPassword(),"password3");
    	
    	assertEquals(notFound.isPresent(),false);
    	
    }

}