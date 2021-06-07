package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

}
