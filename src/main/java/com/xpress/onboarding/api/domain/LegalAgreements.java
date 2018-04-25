package com.xpress.onboarding.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LegalAgreements implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1947380782898326070L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer agreementId;
	@Column
	private String agreementName;
	@Column
	private String agreementStartDate;
	@Column
	private String agreementEndDate;
	@Column
	private String fileName;

	public LegalAgreements() {
		super();
	}

	public Integer getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(Integer agreementId) {
		this.agreementId = agreementId;
	}

	public String getAgreementName() {
		return agreementName;
	}

	public void setAgreementName(String agreementName) {
		this.agreementName = agreementName;
	}

	public String getAgreementStartDate() {
		return agreementStartDate;
	}

	public void setAgreementStartDate(String agreementStartDate) {
		this.agreementStartDate = agreementStartDate;
	}

	public String getAgreementEndDate() {
		return agreementEndDate;
	}

	public void setAgreementEndDate(String agreementEndDate) {
		this.agreementEndDate = agreementEndDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("LEGAL AGREEMENT DETAILS");
		stringBuilder.append("agreementId").append(agreementId);
		stringBuilder.append("agreementName").append(agreementName);
		stringBuilder.append("agreementStartDate").append(agreementStartDate);
		stringBuilder.append("agreementEndDate").append(agreementEndDate);
		stringBuilder.append("fileName").append(fileName);
		return stringBuilder.toString();
	}

}
