package com.oracleoaec.pojo;

public class Dept {
	
	private Integer deptId;
	private String deptName;
	private Integer deptStatus;
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getDeptStatus() {
		return deptStatus;
	}
	public void setDeptStatus(Integer deptStatus) {
		this.deptStatus = deptStatus;
	}
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", deptStatus=" + deptStatus + "]";
	}
	
}
