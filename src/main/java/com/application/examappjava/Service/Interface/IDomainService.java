package com.application.examappjava.Service.Interface;

import com.application.examappjava.Dto.DomainDto;
import com.application.examappjava.Entity.Domain;

import java.util.List;

public interface IDomainService {

    public DomainDto addDomain(DomainDto domainDto);
    public Domain getDomainById(long id);
    public List<DomainDto> getAllDomain();
    public String deletedomainById(long bookId);
    public Domain updateDomain(long id, Domain updatedDomain);
}
