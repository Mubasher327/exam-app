package com.application.examappjava.service;

import com.application.examappjava.dto.CandidateDto;
import com.application.examappjava.entity.Candidate;
import com.application.examappjava.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepo;

    public CandidateService(CandidateRepository candidateRepo) {
        this.candidateRepo = candidateRepo;
    }


    public void addCandidate(CandidateDto candidateDto) {
        Candidate candidate=new Candidate(candidateDto);
        candidateRepo.save(candidate);

    }

    public CandidateDto getCandidateByID(Long id) {
        return candidateRepo.findById(id)
                .map(CandidateDto::new)
                .orElse(null);
    }

    public List<CandidateDto> getAllCandidates() {
        return candidateRepo.findAll().stream().map(CandidateDto::new).collect(Collectors.toList());
    }

    public boolean deleteCandidateByID(Long id) {
        if (candidateRepo.existsById(id)) {
            candidateRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateCandidate(Long id, CandidateDto updatedCandidate) {
        Candidate existingCandidate = candidateRepo.findById(id).orElse(null);

        if (existingCandidate != null) {
            existingCandidate.updateFromDto(updatedCandidate);
            candidateRepo.save(existingCandidate);
            return true;
        } else {
            return false;
        }
    }
}
