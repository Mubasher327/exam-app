package com.application.examappjava.service;

import com.application.examappjava.dto.DomainDto;
import com.application.examappjava.entity.Domain;
import com.application.examappjava.repository.DomainRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainService {
    private final DomainRepository domainRepository;

    public DomainService(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }


    public void addDomain(DomainDto domainDto) {
        Domain domain=new Domain(domainDto);
        domainRepository.save(domain);

    }

    public DomainDto getDomainByID(Long id) {
        return domainRepository.findById(id)
                .map(DomainDto::new)
                .orElse(null);
    }

    public List<DomainDto> getAllDomains() {
        return domainRepository.findAll().stream().map(DomainDto::new).collect(Collectors.toList());
    }

    public boolean deleteDomainByID(Long id) {
        if (domainRepository.existsById(id)) {
            domainRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateDomain(Long id, DomainDto updatedDomain) {
        Domain existingDomain = domainRepository.findById(id).orElse(null);

        if (existingDomain != null) {
            existingDomain.updateFromDto(updatedDomain);
            domainRepository.save(existingDomain);
            return true;
        } else {
            return false;
        }
    }

}