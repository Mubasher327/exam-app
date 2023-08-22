package com.application.examappjava.Controller;

import com.application.examappjava.Dto.DomainDto;
import com.application.examappjava.Entity.Domain;
import com.application.examappjava.Service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domain")
public class DomainController {
    @Autowired
    DomainDto domainDto;
    private final DomainService domainService;

    public DomainController(DomainService domainService) {
        this.domainService = domainService;
    }

    @PostMapping
    public ResponseEntity<String> AddDomain(@RequestBody DomainDto domain) {
        domainService.addDomain(domain);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomainDto> getPostById(@PathVariable Long id) {
        Domain domain = domainService.getDomainById(id);
        if (domain != null) {
            return new ResponseEntity<>(domainDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<DomainDto>> getAlldomains() {
        List<DomainDto> posts = domainService.getAllDomain();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletedomainById(@PathVariable Long id) {
        boolean deleted = domainService.deletedomainById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDomain(@PathVariable Long id, @RequestBody DomainDto updatedDomain) {
        Domain existingDomain = domainService.getDomainById(id);
        if (existingDomain == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existingDomain.setName(updatedDomain.getName());
        existingDomain.setDescription(updatedDomain.getDescription());
        existingDomain.setModifiedBy(updatedDomain.getModifiedBy());

        domainService.updateDomain(id, updatedDomain.dissamble());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    }

