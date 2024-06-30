package com.igrowker.cvinter.controller;


import com.igrowker.cvinter.service.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private IRecruiterService recruiterService;


    @GetMapping("/candidates")
    public ResponseEntity<?> getCandidates() {
        return new ResponseEntity<>("Recruiters", HttpStatus.OK);
    }

    @PostMapping("/schedule-call")
    public ResponseEntity<?> scheduleCall() {
        return new ResponseEntity<>("Recruiter", HttpStatus.OK);
    }

}
