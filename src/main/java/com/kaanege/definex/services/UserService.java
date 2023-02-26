package com.kaanege.definex.services;

import com.kaanege.definex.entities.User;
import com.kaanege.definex.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    private final CreditsService creditsService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(creditsService.adjustedUser(newUser));
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setIncome(newUser.getIncome());
            foundUser.setPhoneNumber(newUser.getPhoneNumber());
            foundUser.setFullName(newUser.getFullName());
            foundUser.setCreditScore(newUser.getCreditScore());
            foundUser.setDeposit(newUser.getDeposit());
            userRepository.save(creditsService.adjustedUser(foundUser));
            return creditsService.adjustedUser(foundUser);
        } else {
            return null;
        }

    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public Optional<User> getOneUserBySsn(String ssn) {

        return userRepository.findBySsn(ssn);
    }
}
