package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
