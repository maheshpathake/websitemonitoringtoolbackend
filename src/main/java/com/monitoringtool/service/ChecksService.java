package com.monitoringtool.service;

import com.monitoringtool.model.Checks;
import com.monitoringtool.repository.ChecksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ChecksService {

    @Autowired
    private ChecksRepository checksRepository;

    public Checks addNewCheck(Checks checks) {
        return checksRepository.save(checks);
    }

    public List<Checks> getAllChecks() {
        return checksRepository.findAll();
    }

    public Checks getCheckById(Long id) {
        return checksRepository.findById(id).get();
    }

    public void deleteCheck(Long id) {
        checksRepository.deleteById(id);
    }
}
