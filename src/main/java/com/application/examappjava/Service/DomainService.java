package com.application.examappjava.Service;

import com.application.examappjava.Dto.DomainDto;
import com.application.examappjava.Entity.Domain;
import com.application.examappjava.Repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainService {
    @Autowired
    DomainRepository domainRepository;

    public DomainDto addDomain(DomainDto domainDto) {

    return  new DomainDto(domainRepository.save(domainDto.dissamble()));

    }

    public Domain getDomainById(long id){
        return domainRepository.findById(id).get();
    }

    public List<DomainDto> getAllDomain() {
        return domainRepository.findAll().stream().map(DomainDto::new).collect(Collectors.toList());
    }

    public boolean deletedomainById(long bookId) {
       boolean deleted= Boolean.parseBoolean(null);
        domainRepository.deleteById(bookId);
        return deleted;
    }
    public Domain updateDomain(long id, Domain updatedDomain){
        Domain existingDomain = domainRepository.findById(id).get();
        if (existingDomain != null) {
            existingDomain.setName(updatedDomain.getName());
            existingDomain.setDescription(updatedDomain.getDescription());
            existingDomain.setModifiedBy(updatedDomain.getModifiedBy());
            domainRepository.save(existingDomain);
        }
    return existingDomain;
    }


}
