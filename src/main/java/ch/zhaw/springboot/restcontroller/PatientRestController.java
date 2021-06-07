package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Patient;
import ch.zhaw.springboot.models.InfectionRequest;
import ch.zhaw.springboot.repositories.DiagnosisRepository;
import ch.zhaw.springboot.repositories.PatientRepository;
import ch.zhaw.springboot.repositories.ConditionRepository;

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
}
