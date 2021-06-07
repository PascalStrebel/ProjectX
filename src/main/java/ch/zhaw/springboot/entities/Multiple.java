package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Multiple extends AbstractCondition {

	//TODO enum
	private String severity;

	@OneToMany(mappedBy = "multiple")
	private List<Icd10Disease> diseases;

	public Multiple(String name, String severity) {
		super(name);
		this.severity = severity;
	}

	public Multiple() {

	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public List<Icd10Disease> getDiseases() {
		return diseases;
	}
}
