package com.example.facturationproject.application.query.user;

import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.domain.user.UserRepository;
import com.example.facturationproject.infrastructure.Dto.user.UserResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import java.time.LocalDateTime;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserFindTest {

    private UserFind userFind;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
//        MockitoAnnotations.openMocks(this);
        userFind = new UserFind(userRepository);

    }

    @Test
    public void testFindById() {

        Long id = 1L;
        User user = new User();
        user.setId(id);
        user.setName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setCreateAt(LocalDateTime.now());


        when(userRepository.findById(id)).thenReturn(Optional.of(user));


        UserResponse userResponse = userFind.findById(id);


        verify(userRepository, times(1)).findById(id);


        assertEquals(user.getName(), userResponse.name());
        assertEquals(user.getLastName(), userResponse.lastName());
        assertEquals(user.getEmail(), userResponse.email());
        assertEquals(user.getCreateAt(), userResponse.CreateAt());
    }

    @Test
    void findByEmail() {

        Long id = 1L;
        User user = new User();
        user.setId(id);
        user.setName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setCreateAt(LocalDateTime.now());
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));


        User userResponse = userFind.findByEmail(user.getEmail());

        verify(userRepository, times(1)).findByEmail(user.getEmail());


        assertEquals(user.getName(), userResponse.getName());
        assertEquals(user.getLastName(), userResponse.getLastName());
        assertEquals(user.getEmail(), userResponse.getEmail());
        assertEquals(user.getCreateAt(), userResponse.getCreateAt());

    }
}