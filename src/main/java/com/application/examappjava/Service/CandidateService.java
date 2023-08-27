package com.application.examappjava.service;

import com.application.examappjava.dto.CandidateDto;
import com.application.examappjava.dto.EducationDto;
import com.application.examappjava.dto.ExperienceDto;
import com.application.examappjava.entity.Candidate;
import com.application.examappjava.entity.Education;
import com.application.examappjava.entity.Experience;
import com.application.examappjava.repository.CandidateRepository;
import com.application.examappjava.repository.EducationRepository;
import com.application.examappjava.repository.ExperienceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepo;
    private final EducationRepository educationalRepo;
    private final ExperienceRepository experienceRepo;
    private final EducationService educationService;
    private final ExperienceService experienceService;

    public CandidateService(CandidateRepository candidateRepo, EducationRepository educationRepo, ExperienceRepository experienceRepo, EducationRepository educationalRepo, ExperienceRepository experienceRepo1, EducationService educationService, ExperienceService experienceService) {
        this.candidateRepo = candidateRepo;
        this.educationalRepo = educationalRepo;
        this.experienceRepo = experienceRepo1;
        this.educationService = educationService;
        this.experienceService = experienceService;
    }


//    public void addCandidate(CandidateDto candidateDto) {
//        Candidate candidate=new Candidate(candidateDto);
//        candidateRepo.save(candidate);
//    }

    public CandidateDto saveCandidate(CandidateDto candidateDto) {
        Candidate candidate = new Candidate(candidateDto);
        Candidate savedCandidate = candidateRepo.save(candidate);

        for (EducationDto educationDto : candidateDto.getEducations()) {
            educationService.saveEducation(educationDto, savedCandidate);
        }

        for (ExperienceDto experienceDto : candidateDto.getExperiences()) {
            experienceService.saveExperience(experienceDto, savedCandidate);
        }

        return new CandidateDto(candidate);
    }

    public CandidateDto getCandidateAndRelated(Long candidateId) {
        Candidate candidate = candidateRepo.findByIdAndDeletedIsFalse(candidateId);
        if (candidate != null) {
            CandidateDto candidateDto = new CandidateDto(candidate);
            candidateDto.setEducations(educationalRepo.findByCandidateIdAndDeletedIsFalse(candidateId)
                    .stream()
                    .map(EducationDto::new)
                    .collect(Collectors.toList()));
            candidateDto.setExperiences(experienceRepo.findByCandidateIdAndDeletedIsFalse(candidateId)
                    .stream()
                    .map(ExperienceDto::new)
                    .collect(Collectors.toList()));
            return candidateDto;
        }
        return null;
    }

    public List<CandidateDto> getAllCandidates() {
        List<Candidate> candidates = candidateRepo.findAllByDeletedIsFalse();
        return candidates.stream()
                .map(CandidateDto::new)
                .collect(Collectors.toList());
    }

    public boolean deleteCandidateByID(Long id) {
        if (candidateRepo.existsById(id)) {
            candidateRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateCandidate(Long id, CandidateDto updatedCandidateDto) {
        Optional<Candidate> optionalCandidate = candidateRepo.findById(id);

        if (optionalCandidate.isPresent()) {
            Candidate candidate = optionalCandidate.get();

            // Update candidate details
            candidate.setFirstName(updatedCandidateDto.getFirstName());
            candidate.setLastName(updatedCandidateDto.getLastName());
            candidate.setPhoneNo(updatedCandidateDto.getPhoneNo());
            candidate.setCnic(updatedCandidateDto.getCnic());
            candidate.setPermanentAddress(updatedCandidateDto.getPermanentAddress());
            candidate.setCurrentAddress(updatedCandidateDto.getCurrentAddress());

            // Update education list
            Map<Long, Education> existingEducationsMap = candidate.getEducations().stream()
                    .collect(Collectors.toMap(Education::getId, edu -> edu));

            for (EducationDto updatedEducationDto : updatedCandidateDto.getEducations()) {
                Education existingEducation = existingEducationsMap.get(updatedEducationDto.getId());

                if (existingEducation != null) {
                    // Update education details
                    existingEducation.setUniversityName(updatedEducationDto.getUniversityName());
                    existingEducation.setDegree(updatedEducationDto.getDegree());
                    existingEducation.setCampus(updatedEducationDto.getCampus());
                    existingEducation.setCgpa(updatedEducationDto.getCgpa());
                    existingEducation.setStartDate(updatedEducationDto.getStartDate());
                    existingEducation.setEndDate(updatedEducationDto.getEndDate());

                }
            }

            // Update experience list
            Map<Long, Experience> existingExperiencesMap = candidate.getExperiences().stream()
                    .collect(Collectors.toMap(Experience::getId, exp -> exp));

            for (ExperienceDto updatedExperienceDto : updatedCandidateDto.getExperiences()) {
                Experience existingExperience = existingExperiencesMap.get(updatedExperienceDto.getId());

                if (existingExperience != null) {
                    // Update experience details
                    existingExperience.setCompanyName(updatedExperienceDto.getCompanyName());
                    existingExperience.setRole(updatedExperienceDto.getRole());
                    existingExperience.setStartYear(updatedExperienceDto.getStartYear());
                    existingExperience.setEndYear(updatedExperienceDto.getEndYear());
                    existingExperience.setExpectedSalary(updatedExperienceDto.getExpectedSalary());
                    existingExperience.setCurrentSalary(updatedExperienceDto.getCurrentSalary());
                }
            }

            candidateRepo.save(candidate);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean softDeleteCandidateAndRelated(Long candidateId) {
        Optional<Candidate> optionalCandidate = candidateRepo.findById(candidateId);

        if (optionalCandidate.isPresent()) {
            Candidate candidate = optionalCandidate.get();
            candidate.setDeleted(true);

            // Cascading soft delete to associated educations
            for (Education education : candidate.getEducations()) {
                education.setDeleted(true);
            }

            // Cascading soft delete to associated experiences
            for (Experience experience : candidate.getExperiences()) {
                experience.setDeleted(true);
            }

            candidateRepo.save(candidate);
            return true;
        }

        return false;
    }
}
