package com.example.facturationproject.application.commant.User;

import com.example.facturationproject.domain.user.User;
import com.example.facturationproject.domain.user.UserRepository;
import com.example.facturationproject.infrastructure.controller.exceptionControler.exceptions.NotFondException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeletedUser {

    private final UserRepository userRepository;

    public void delete(Long id){
      User user = userRepository.findById(id).orElseThrow(() -> new NotFondException("User not found"));
      user.setDeleted(true);
      userRepository.save(user);

    }

}


