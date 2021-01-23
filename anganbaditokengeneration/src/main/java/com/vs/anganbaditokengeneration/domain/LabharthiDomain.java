package com.vs.anganbaditokengeneration.domain;


/**
 * @author Vikas.singh
 */
public class LabharthiDomain {
	
	private String labharthiName;
	
	private String nameOfFather;
	
	private String nameOfMother;
	
	private String aadharNum;
	
	private String mobileNum;
	
	private String allFamilyNames;

	public String getLabharthiName() {
		return labharthiName;
	}

	public void setLabharthiName(String labharthiName) {
		this.labharthiName = labharthiName;
	}

	public String getNameOfFather() {
		return nameOfFather;
	}

	public void setNameOfFather(String nameOfFather) {
		this.nameOfFather = nameOfFather;
	}

	public String getNameOfMother() {
		return nameOfMother;
	}

	public void setNameOfMother(String nameOfMother) {
		this.nameOfMother = nameOfMother;
	}

	public String getAadharNum() {
		return aadharNum;
	}

	public void setAadharNum(String aadharNum) {
		this.aadharNum = aadharNum;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getAllFamilyNames() {
		return allFamilyNames;
	}

	public void setAllFamilyNames(String allFamilyNames) {
		this.allFamilyNames = allFamilyNames;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobileNum == null) ? 0 : mobileNum.hashCode());
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
		LabharthiDomain other = (LabharthiDomain) obj;
		if (mobileNum == null) {
			if (other.mobileNum != null)
				return false;
		} else if (!mobileNum.equals(other.mobileNum))
			return false;
		return true;
	}

	

}
