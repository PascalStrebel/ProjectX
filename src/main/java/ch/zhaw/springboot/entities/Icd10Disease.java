package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Icd10Disease extends AbstractCondition {

	@ManyToOne
	@JoinColumn(name = "multiple_id")
	private Multiple multiple;

	private String code;

	public Icd10Disease(String name, String code) {
		super(name);
		this.code = code;
	}

	public Icd10Disease() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
