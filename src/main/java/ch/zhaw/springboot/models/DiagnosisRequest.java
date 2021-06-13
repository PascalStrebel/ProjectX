package ch.zhaw.springboot.models;

public class DiagnosisRequest {
	private String patientId;
	private String conditionId;

	public DiagnosisRequest(String patientId, String conditionId) {
		this.patientId = patientId;
		this.conditionId = conditionId;
	}

	public String getPatientId() {
		return patientId;
	}

	public String getConditionId() {
		return conditionId;
	}
}
