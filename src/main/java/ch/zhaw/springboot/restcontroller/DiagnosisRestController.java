package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Diagnosis;
import ch.zhaw.springboot.entities.Patient;
import ch.zhaw.springboot.models.DiagnosisRequest;
import ch.zhaw.springboot.models.PatientRequest;
import ch.zhaw.springboot.repositories.ConditionRepository;
import ch.zhaw.springboot.repositories.DiagnosisRepository;
import ch.zhaw.springboot.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class DiagnosisRestController {

	@Autowired
	private DiagnosisRepository repository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private ConditionRepository conditionRepository;

	@RequestMapping(value = "patients/diagnosis", method = RequestMethod.GET)
	public ResponseEntity<List<Diagnosis>> getDiagnosis() {
		List<Diagnosis> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "patients/diagnosis/{id}", method = RequestMethod.GET)
	public ResponseEntity<Diagnosis> getDiagnosisById(@PathVariable("id") long id) {
		Optional<Diagnosis> result = this.repository.findById(id);
		return result.map(diagnosis -> new ResponseEntity<>(diagnosis, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping(value = "patients/diagnosis")
	public ResponseEntity<Diagnosis> createDiagnosis(@RequestBody DiagnosisRequest diagnosisRequest) {
		Diagnosis diagnosis = new Diagnosis();
		diagnosis.setCreatedAt(LocalDate.now());
		patientRepository.findById(Long.valueOf(diagnosisRequest.getPatientId())).ifPresent(diagnosis::setPatient);
		conditionRepository.findById(Long.valueOf(diagnosisRequest.getConditionId())).ifPresent(diagnosis::setCondition);
		Diagnosis result = this.repository.save(diagnosis);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
