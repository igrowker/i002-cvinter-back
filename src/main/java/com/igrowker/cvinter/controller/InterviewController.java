package com.igrowker.cvinter.controller;


import com.igrowker.cvinter.service.IInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/intervies")
public class InterviewController {

    @Autowired
    private IInterviewService interviewService;


    @PostMapping("")
    public ResponseEntity<?> createInterview() {
        return new ResponseEntity<>("Interview", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getInterviews() {
        return new ResponseEntity<>("Interviews", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInterviewById(@RequestParam Long id) {
        if (interview.isPresent()) {
            return new ResponseEntity<>(interview.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        

}
}
