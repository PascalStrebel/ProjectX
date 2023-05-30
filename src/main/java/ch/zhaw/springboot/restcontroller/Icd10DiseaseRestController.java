package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Icd10Disease;
import ch.zhaw.springboot.entities.Multiple;
import ch.zhaw.springboot.repositories.Icd10DiseaseRepository;
import ch.zhaw.springboot.repositories.MultipleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class Icd10DiseaseRestController {

	@Autowired
	private Icd10DiseaseRepository repository;

	@RequestMapping(value = "patients/icd10", method = RequestMethod.GET)
	public ResponseEntity<List<Icd10Disease>> getIcd10Disease() {
		List<Icd10Disease> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "patients/icd10/{id}", method = RequestMethod.GET)
	public ResponseEntity<Icd10Disease> getIcd10DiseaseById(@PathVariable("id") long id) {
		Optional<Icd10Disease> result = this.repository.findById(id);
		return result.map(multiple -> new ResponseEntity<>(multiple, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
