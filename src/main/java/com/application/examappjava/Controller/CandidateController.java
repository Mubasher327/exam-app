package com.application.examappjava.controller;

import com.application.examappjava.dto.CandidateDto;
import com.application.examappjava.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {


    private final CandidateService candidateService;


    public CandidateController( CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public ResponseEntity<Void> addCandidate(@RequestBody final CandidateDto candidate) {
        candidateService.addCandidate(candidate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateDto> getCandidateByID(@PathVariable final Long id) {
        CandidateDto candidateDto = candidateService.getCandidateByID(id);
        if (candidateDto != null) {
            return ResponseEntity.ok(candidateDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CandidateDto>> getAllDomains() {
        List<CandidateDto> domains = candidateService.getAllCandidates();
        return new ResponseEntity<>(domains, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCandidateByID(@PathVariable final Long id) {
        boolean deleted = candidateService.deleteCandidateByID(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCandidate(@PathVariable final Long id, @RequestBody final CandidateDto updatedCandidate) {
        boolean isSuccess = candidateService.updateCandidate(id, updatedCandidate);

        if (isSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
