package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Icd10Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Icd10DiseaseRepository extends JpaRepository<Icd10Disease, Long> {

}
