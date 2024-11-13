package com.tka.eci.entity;

public class Candidate {

	private String name;
	private String partyname;
	private String assembly;
	private String gender;
	private int age;

	public Candidate() {
		super();
	}

	public Candidate(String name, String partyname, String assembly, String gender, int age) {
		super();
		this.name = name;
		this.partyname = partyname;
		this.assembly = assembly;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartyname() {
		return partyname;
	}

	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}

	public String getAssembly() {
		return assembly;
	}

	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Candidate [Name = " + name + ", Partyname = " + partyname + ", Assembly = " + assembly + ", Gender = "
				+ gender + ", Age = " + age + "]";
	}

}
