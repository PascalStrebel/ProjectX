package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Diagnosis;
import ch.zhaw.springboot.entities.Multiple;
import ch.zhaw.springboot.models.DiagnosisRequest;
import ch.zhaw.springboot.repositories.ConditionRepository;
import ch.zhaw.springboot.repositories.DiagnosisRepository;
import ch.zhaw.springboot.repositories.MultipleRepository;
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
public class MultipleRestController {

	@Autowired
	private MultipleRepository repository;

	@RequestMapping(value = "patients/multiple", method = RequestMethod.GET)
	public ResponseEntity<List<Multiple>> getMultiple() {
		List<Multiple> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "patients/multiple/{id}", method = RequestMethod.GET)
	public ResponseEntity<Multiple> getMultipleById(@PathVariable("id") long id) {
		Optional<Multiple> result = this.repository.findById(id);
		return result.map(multiple -> new ResponseEntity<>(multiple, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
