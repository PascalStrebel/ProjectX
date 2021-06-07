package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.AbstractCondition;
import ch.zhaw.springboot.entities.Diagnosis;
import ch.zhaw.springboot.repositories.ConditionRepository;
import ch.zhaw.springboot.repositories.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ConditionRestController {

	@Autowired
	private ConditionRepository repository;

	@RequestMapping(value = "patients/conditions", method = RequestMethod.GET)
	public ResponseEntity<List<AbstractCondition>> getConditions() {
		List<AbstractCondition> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "patients/conditions/{id}", method = RequestMethod.GET)
	public ResponseEntity<AbstractCondition> getConditionById(@PathVariable("id") long id) {
		Optional<AbstractCondition> result = this.repository.findById(id);
		return result.map(diagnosis -> new ResponseEntity<>(diagnosis, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
