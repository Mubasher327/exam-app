package com.application.examappjava.controller;

import com.application.examappjava.dto.DomainDto;
import com.application.examappjava.service.DomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/domain")
public class DomainController {

    private final DomainService domainService;

    public DomainController(DomainService domainService) {

        this.domainService = domainService;
    }

    @PostMapping
    public ResponseEntity<Void> addDomain(@RequestBody final DomainDto domain) {
        domainService.addDomain(domain);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomainDto> getDomainByID(@PathVariable final Long id) {
        DomainDto domainDto = domainService.getDomainByID(id);
        if (domainDto != null) {
            return ResponseEntity.ok(domainDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<DomainDto>> getAllDomains() {
        List<DomainDto> domains = domainService.getAllDomains();
        return new ResponseEntity<>(domains, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDomainByID(@PathVariable final Long id) {
        boolean deleted = domainService.deleteDomainByID(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDomain(@PathVariable final Long id, @RequestBody final DomainDto updatedDomain) {
        boolean isSuccess = domainService.updateDomain(id, updatedDomain);

        if (isSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}