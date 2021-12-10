package com.tyss.esslite.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contract_type")
public class ContractTypeInfo {
	
	@Id
	@Column(name="contract_id")
	private int contractId;
	
	@Column(name="contract_type", length=15)
	private String contractType;
	
	
	public ContractTypeInfo() {
	}


	public ContractTypeInfo(int contractId, String contractType) {
		super();
		this.contractId = contractId;
		this.contractType = contractType;
	}


	public int getContractId() {
		return contractId;
	}


	public void setContractId(int contractId) {
		this.contractId = contractId;
	}


	public String getContractType() {
		return contractType;
	}


	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	

}
