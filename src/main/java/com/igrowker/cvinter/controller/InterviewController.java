package com.igrowker.cvinter.controller;


import com.igrowker.cvinter.model.dto.InterviewDTO;
import com.igrowker.cvinter.service.IInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    @Autowired
    private IInterviewService interviewService;


    @PostMapping("")
    public ResponseEntity<?> createInterview() { //! IMPLEMENTAR
        return new ResponseEntity<>("Interview", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getInterviews() {

        List<InterviewDTO> interviews = interviewService.getAllInterviews();

        if (interviews.isEmpty())
            return new ResponseEntity<>("No interviews found", HttpStatus.NOT_FOUND);

        else
            return new ResponseEntity<>(interviews, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInterviewById(@RequestParam Long id) {

        if (id == null)
            return new ResponseEntity<>("No id provided", HttpStatus.BAD_REQUEST);

        InterviewDTO interview = interviewService.getInterviewById(id);

        if (interview == null)
            return new ResponseEntity<>("Interview not found", HttpStatus.NOT_FOUND);

        else
            return new ResponseEntity<>(interview, HttpStatus.OK);
    }
}
