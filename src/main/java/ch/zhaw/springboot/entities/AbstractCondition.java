package ch.zhaw.springboot.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractCondition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long conditionId;

	private String name;

	public AbstractCondition(String name) {
		this.name = name;
	}

	public AbstractCondition() {

	}

	public long getConditionId() {
		return conditionId;
	}

	public void setConditionId(long id) {
		this.conditionId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
