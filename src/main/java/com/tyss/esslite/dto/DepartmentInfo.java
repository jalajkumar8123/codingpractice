package com.tyss.esslite.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department_info")
public class DepartmentInfo {
	
	@Id
    @Column(name="department_id")
	private int departmentId;
	
	
	@Column(name="department_name", length=15)
	private String departmentName;
	
	
	public DepartmentInfo() {
	}


	public DepartmentInfo(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	

}
