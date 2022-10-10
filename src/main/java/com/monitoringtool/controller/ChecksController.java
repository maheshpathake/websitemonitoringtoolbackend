package com.monitoringtool.controller;

import com.monitoringtool.model.Checks;
import com.monitoringtool.repository.ChecksRepository;
import com.monitoringtool.service.ChecksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin

@RequestMapping("/api/v1/")
public class ChecksController {

    @Autowired
    ChecksService checksService;

    @Autowired
    ChecksRepository checksRepository;

    // save check
    @PostMapping("/check")
    public Checks addCheck(@RequestBody Checks checks) {
        return checksService.addNewCheck(checks);
    }

    // get all checks
    @GetMapping("/checks")
    public List<Checks> getAllChecks() {
        return checksService.getAllChecks();
    }

    // get by id
    @GetMapping("/check/{id}")
    public ResponseEntity<Checks> getCheckById(@PathVariable Long id) {
        Checks checks = checksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Check not exist with id :" + id));
        return ResponseEntity.ok(checks);
    }

    @PutMapping("/check/{id}")
    public ResponseEntity<Checks> updateCheck(@PathVariable Long id, @RequestBody Checks checksDetails) {
        Checks checks = checksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Check not exist with id :" + id));

        checks.setWebsiteName(checksDetails.getWebsiteName());
        checks.setWebsiteUrl(checksDetails.getWebsiteUrl());
        checks.setWebsiteFrequency(checksDetails.getWebsiteFrequency());


        Checks updatedChecks = checksService.addNewCheck(checks);
        return ResponseEntity.ok(updatedChecks);
    }

    // delete check rest api
    @DeleteMapping("/checks/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCheck(@PathVariable Long id) {
        Checks checks = checksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Check not exist with id :" + id));

        checksService.deleteCheck(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
