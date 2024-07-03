package com.igrowker.cvinter.controller;


import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.service.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private IRecruiterService recruiterService;


    @GetMapping("/candidates")
    public ResponseEntity<?> getCandidates() {

        List<UserDTO> candidates = recruiterService.getCandidates();

        if (candidates.isEmpty())
            return new ResponseEntity<>("No candidates found", HttpStatus.NOT_FOUND);

        else
            return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @PostMapping("/schedule-call")
    public ResponseEntity<?> scheduleCall() { //! IMPLEMENTAR
        return new ResponseEntity<>("Recruiter", HttpStatus.OK);
    }

}
