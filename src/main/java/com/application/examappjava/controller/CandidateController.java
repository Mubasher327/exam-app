package com.application.examappjava.controller;

import com.application.examappjava.dto.CandidateDto;
import com.application.examappjava.service.CandidateService;
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


    @PostMapping("/save")
    public ResponseEntity<CandidateDto> saveCandidate(@RequestBody CandidateDto candidateDto) {
        CandidateDto savedCandidate = candidateService.saveCandidate(candidateDto);

        if (savedCandidate != null) {
            return ResponseEntity.ok(savedCandidate);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateDto> getCandidateAndRelated(@PathVariable Long id) {
        CandidateDto candidateDto = candidateService.getCandidateAndRelated(id);
        if (candidateDto != null) {
            return ResponseEntity.ok(candidateDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CandidateDto>> getAllCandidates() {
        List<CandidateDto> candidates = candidateService.getAllCandidates();
        return ResponseEntity.ok(candidates);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCandidate(@PathVariable Long id, @RequestBody CandidateDto updatedCandidateDto) {
        boolean isSuccess = candidateService.updateCandidate(id, updatedCandidateDto);

        if (isSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> softDeleteCandidateAndRelated(@PathVariable Long id) {
        boolean success = candidateService.softDeleteCandidateAndRelated(id);
        if (success) {
            return ResponseEntity.ok("Candidate and related records soft deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    }
