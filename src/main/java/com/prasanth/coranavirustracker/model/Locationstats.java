package com.prasanth.coranavirustracker.model;

public class Locationstats {
	
	@Override
	public String toString() {
		return "Locationstats [state=" + state + ", country=" + country + ", latesttotalcases=" + latesttotalcases
				+ "]";
	}
	private String state;
	private String country;
	private int latesttotalcases;
	private int diffprevday;
	
	
	public int getDiffprevday() {
		return diffprevday;
	}
	public void setDiffprevday(int diffprevday) {
		this.diffprevday = diffprevday;
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
	public int getLatesttotalcases() {
		return latesttotalcases;
	}
	public void setLatesttotalcases(int latesttotalcases) {
		this.latesttotalcases = latesttotalcases;
	}
	

}
