package kz.bitlab.spring_jpa.services;

import kz.bitlab.spring_jpa.models.ApplicationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ApplicationRequestService {
    List<ApplicationRequest> getApplicationRequest();
    void  AddNewApplication(ApplicationRequest applicationRequest);

    ApplicationRequest findById(Long id);
    void deleteById(Long id);
}
