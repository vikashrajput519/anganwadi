package com.vs.anganbaditokengeneration;

public class LabharthiDto {
	
	private String kendraId;
	
	private String nameOfMother;
	
	private String nameOfFather;
	
	private String aadharNum;
	
	private String ifcCode;
	
	private String accountNum;
	
	private String labhartiType;
	
	private String category;
	
	private String ageInMonths;
	
	private String benificeryName;
	
	private String gender;
	
	private String yearOfBirth;
	
	private String benId;
	
	private String tokenId;
	
	public LabharthiDto() {
		super();
	}
	
	public LabharthiDto(String kendraId, String nameOfMother, String nameOfFather, String accountNum,
			String ageInMonths, String benificeryName, String benId, String tokenId) {
		super();
		this.kendraId = kendraId;
		this.nameOfMother = nameOfMother;
		this.nameOfFather = nameOfFather;
		this.accountNum = accountNum;
		this.ageInMonths = ageInMonths;
		this.benificeryName = benificeryName;
		this.benId = benId;
		this.tokenId = tokenId;
	}

	public String getKendraId() {
		return kendraId;
	}

	public void setKendraId(String kendraId) {
		this.kendraId = kendraId;
	}

	public String getNameOfMother() {
		return nameOfMother;
	}

	public void setNameOfMother(String nameOfMother) {
		this.nameOfMother = nameOfMother;
	}

	public String getNameOfFather() {
		return nameOfFather;
	}

	public void setNameOfFather(String nameOfFather) {
		this.nameOfFather = nameOfFather;
	}

	public String getAadharNum() {
		return aadharNum;
	}

	public void setAadharNum(String aadharNum) {
		this.aadharNum = aadharNum;
	}

	public String getIfcCode() {
		return ifcCode;
	}

	public void setIfcCode(String ifcCode) {
		this.ifcCode = ifcCode;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getLabhartiType() {
		return labhartiType;
	}

	public void setLabhartiType(String labhartiType) {
		this.labhartiType = labhartiType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAgeInMonths() {
		return ageInMonths;
	}

	public void setAgeInMonths(String ageInMonths) {
		this.ageInMonths = ageInMonths;
	}

	public String getBenificeryName() {
		return benificeryName;
	}

	public void setBenificeryName(String benificeryName) {
		this.benificeryName = benificeryName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getBenId() {
		return benId;
	}

	public void setBenId(String benId) {
		this.benId = benId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tokenId == null) ? 0 : tokenId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LabharthiDto other = (LabharthiDto) obj;
		if (tokenId == null) {
			if (other.tokenId != null)
				return false;
		} else if (!tokenId.equals(other.tokenId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LabharthiDto [kendraId=" + kendraId + ", nameOfMother=" + nameOfMother + ", nameOfFather="
				+ nameOfFather + ", aadharNum=" + aadharNum + ", ifcCode=" + ifcCode + ", accountNum=" + accountNum
				+ ", labhartiType=" + labhartiType + ", category=" + category + ", ageInMonths=" + ageInMonths
				+ ", benificeryName=" + benificeryName + ", gender=" + gender + ", yearOfBirth=" + yearOfBirth
				+ ", benId=" + benId + ", tokenId=" + tokenId + "]";
	}
	
	
	
}
