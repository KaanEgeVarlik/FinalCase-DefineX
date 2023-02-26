package com.kaanege.definex.controllers;

import com.kaanege.definex.entities.User;
import com.kaanege.definex.repositories.UserRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(value = "/sendSMS")
@RequiredArgsConstructor
public class SmsController {
    private final UserRepository userRepository;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/{ssn}/{bornDate}")
    public ResponseEntity<String> sendSMS( @PathVariable String ssn ,@PathVariable LocalDate bornDate) {

        Twilio.init("ACe3e645a5b35c0b8a5ece6f835bcd6d92","d85ef76a826038c592b26d51e6c4652f");

        Optional<User> user = userRepository.findBySsn(ssn);

        if(user.isPresent() && user.get().getBornDate().equals(bornDate)) {
            if(user.get().isResult()){
                Message.creator(new PhoneNumber("+90" + user.get().getPhoneNumber()),
                        new PhoneNumber("+12708177967"), "Your application is accepted. Your credit limit is : " + user.get().getCreditLimit()).create();
            }else{
                Message.creator(new PhoneNumber("+90" + user.get().getPhoneNumber()),
                        new PhoneNumber("+12708177967"), "Your application is denied. ").create();
            }
            return new ResponseEntity<String>("Message sent successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("No application found based on the given information.", HttpStatus.OK);
        }


    }
}
