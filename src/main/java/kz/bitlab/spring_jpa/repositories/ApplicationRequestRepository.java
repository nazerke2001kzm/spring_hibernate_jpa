package kz.bitlab.spring_jpa.repositories;

import kz.bitlab.spring_jpa.models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest,Long> {
    ApplicationRequest getApplicationRequestById(Long Id);
    void deleteApplicationRequestById(Long Id);

}
