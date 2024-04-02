package com.zoom.zoom.service;


import com.zoom.zoom.entity.User;
import com.zoom.zoom.repository.MeetingRepository;
import com.zoom.zoom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    public UserServiceImplementation() {
    }

    private MeetingRepository meetingRepository;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository, MeetingRepository meetingRepository) {
        this.userRepository = userRepository;
        this.meetingRepository=meetingRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
