package com.xpress.onboarding.api.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "companyId", unique = true, nullable = false)
	private Integer companyId;

	@Column
	private String companyName;

	@Column
	private String companyLogo;

	@Column
	private String addressline1;

	@Column
	private String addressLine2;

	@Column
	private String addressLine3;

	@Column
	private String region;

	@Column
	private String state;

	@Column
	private String country;

	@Column
	private String pincode;

/*	@Column(name = "onboardingStatus")
	private boolean onboardingStatus = false;

	@Column(name = "activeStatus")
	private boolean activeStatus = false;*/

	/*
	 * private Date createdOn; private String createdBy; private Date modifiedOn;
	 * private String modifiedBy;
	 */
	/*
	 * @OneToMany(cascade = CascadeType.ALL) Set<Contact> contacts;
	 * 
	 * @OneToMany(cascade = CascadeType.ALL) Set<LegalAgreements> agreements;
	 * 
	 * @OneToMany(cascade = CascadeType.ALL) Set<Accounts> accounts;
	 */
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/*public boolean isOnboardingStatus() {
		return onboardingStatus;
	}

	public void setOnboardingStatus(boolean onboardingStatus) {
		this.onboardingStatus = onboardingStatus;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}*/

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("COMPANY DETAILS");
		stringBuilder.append("companyId:").append(companyId).append(",");
		stringBuilder.append("companyName:").append(companyName).append(",");
		stringBuilder.append("companyLogo:").append(companyLogo).append(",");
		stringBuilder.append("addressline1:").append(addressline1).append(",");
		stringBuilder.append("addressLine2:").append(addressLine2).append(",");
		stringBuilder.append("addressLine3:").append(addressLine3).append(",");
		stringBuilder.append("region:").append(region).append(",");
		stringBuilder.append("state:").append(state).append(",");
		stringBuilder.append("country:").append(country).append(",");
		stringBuilder.append("pincode:").append(pincode).append(",");
		//stringBuilder.append("onboardingStatus:").append(onboardingStatus).append(",");
		//stringBuilder.append("activeStatus:").append(activeStatus);
		// stringBuilder.append("").append();
		return stringBuilder.toString();
	}

}
