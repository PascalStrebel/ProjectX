package ch.zhaw.springboot.restcontroller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.zhaw.springboot.models.PatientSeverityCount;
import ch.zhaw.springboot.models.Severity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Patient;
import ch.zhaw.springboot.repositories.PatientRepository;

@RestController
@CrossOrigin
public class PatientRestController {

    @Autowired
    private PatientRepository repository;

    @RequestMapping(value = "patients/patients", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> getPatients() {
        List<Patient> result = this.repository.findAll();

        if (!result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "patients/patients/{id}", method = RequestMethod.GET)
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") long id) {
        Optional<Patient> result = this.repository.findById(id);
        return result.map(patient -> new ResponseEntity<>(patient, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "patients/patients/findPatientByDiagnosisCreatedAt/{createdAt}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findPatientByDiagnosisCreatedAt(@PathVariable("createdAt") String createdAt) {
        Object[] results = this.repository.findPatientByDiagnosisCreatedAt(LocalDate.parse(createdAt));

        if (results.length > 0) {
            return new ResponseEntity<>(Arrays.stream(results).map(result -> (String) result).collect(Collectors.toList()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "patients/patients/getCountOfSeverityInfoByPatientId/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<PatientSeverityCount>> getCountOfSeverityInfoByPatientId(@PathVariable("id") long id) {
        List<Object[]> results = this.repository.getCountOfSeverityInfoByPatientId(id);

        if (results.size() > 0) {
            return new ResponseEntity<>(results.stream().map(result -> new PatientSeverityCount(((BigInteger)result[0]).intValue(), convertStringToSeverity((String) result[1]), (String) result[2])).collect(Collectors.toList()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public Severity convertStringToSeverity(String id) {
        if (id == null) {
            return null;
        }

        return Stream.of(Severity.values())
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
