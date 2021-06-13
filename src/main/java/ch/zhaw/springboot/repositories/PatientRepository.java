package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT p.name FROM patients.patient p, patients.diagnosis d WHERE p.id = d.patient_id AND d.created_at = ?1", nativeQuery = true)
    Object[] findPatientByDiagnosisCreatedAt(LocalDate createdAt);


    @Query(value = "SELECT count(*), m.severity, p.name\n" +
            "FROM patient p, diagnosis d, abstract_condition c, multiple m\n" +
            "WHERE p.id = d.patient_id\n" +
            "and c.condition_id = d.condition_condition_id\n" +
            "and m.condition_id = c.condition_id\n" +
            "and p.id = ?1\n" +
            "group by m.severity, p.name\n", nativeQuery = true)
    List<Object[]> getCountOfSeverityInfoByPatientId(long id);
}
