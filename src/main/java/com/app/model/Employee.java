package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
@Entity
@Table(name="emptabmvc")
public class Employee {
	@Id
	@GeneratedValue	
	private int empId;
	private String empName;
	private String empPwd;
	private String empGen;
	private String empAddr;
	private String empCntry;
	@ElementCollection
	@CollectionTable(name="emplangtab",joinColumns=@JoinColumn(name="empId"))
	@OrderColumn(name="pos")
	private List<String> empLangs;
	
	public Employee() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public Employee(int empId) {
		super();
		this.empId = empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpGen() {
		return empGen;
	}

	public void setEmpGen(String empGen) {
		this.empGen = empGen;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public String getEmpCntry() {
		return empCntry;
	}

	public void setEmpCntry(String empCntry) {
		this.empCntry = empCntry;
	}

	public List<String> getEmpLangs() {
		return empLangs;
	}

	public void setEmpLangs(List<String> empLangs) {
		this.empLangs = empLangs;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPwd=" + empPwd + ", empGen=" + empGen
				+ ", empAddr=" + empAddr + ", empCntry=" + empCntry + ", empLangs=" + empLangs + "]";
	}
		
}