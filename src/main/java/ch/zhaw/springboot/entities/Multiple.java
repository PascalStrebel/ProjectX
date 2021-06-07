package ch.zhaw.springboot.entities;

import ch.zhaw.springboot.models.Severity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Multiple extends AbstractCondition {

	private Severity severity;

	@OneToMany(mappedBy = "multiple")
	private List<Icd10Disease> diseases;

	public Multiple(String name, Severity severity) {
		super(name);
		this.severity = severity;
	}

	public Multiple() {

	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public List<Icd10Disease> getDiseases() {
		return diseases;
	}
}
