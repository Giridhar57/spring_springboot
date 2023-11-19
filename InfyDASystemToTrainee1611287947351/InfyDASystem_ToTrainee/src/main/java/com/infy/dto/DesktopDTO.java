package com.infy.dto;



public class DesktopDTO {
	
	private String machineName;
	private String make;
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	@Override
	public String toString() {
		return "DesktopDTO [machineName=" + machineName + ", make=" + make + "]";
	}
	
	
	
	
}
