package com.application.examappjava.Controller;

import com.application.examappjava.Dto.CandidateDto;
import com.application.examappjava.Service.CandidateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private final CandidateDto candidateDto;
    private final CandidateService candidateService;


    public CandidateController(CandidateDto candidateDto, CandidateService candidateService) {
        this.candidateDto = candidateDto;
        this.candidateService = candidateService;
    }




}
