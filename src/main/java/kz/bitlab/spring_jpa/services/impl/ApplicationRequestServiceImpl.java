package kz.bitlab.spring_jpa.services.impl;

import kz.bitlab.spring_jpa.models.ApplicationRequest;
import kz.bitlab.spring_jpa.repositories.ApplicationRequestRepository;
import kz.bitlab.spring_jpa.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationRequestServiceImpl implements ApplicationRequestService {
    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;
    @Override
    public List<ApplicationRequest> getApplicationRequest() {
        return applicationRequestRepository.findAll();
    }

    @Override
    public void AddNewApplication(ApplicationRequest applicationRequest) {
        applicationRequestRepository.save(applicationRequest);
    }

    @Override
    public ApplicationRequest findById(Long id) {
       ApplicationRequest applicationRequest=applicationRequestRepository.findById(id).orElseThrow();
        return applicationRequest;
    }

    @Override
    public void deleteById(Long id) {
        applicationRequestRepository.deleteById(id);
    }
}
