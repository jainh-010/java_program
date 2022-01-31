package json_demo;

import java.util.ArrayList;

//pojo object class
public class Student {
	private String name;
	private String fname;
	private String address;
	private ArrayList<Integer> marks = new ArrayList<>();

	public Student() {
		super();
	}

//setter and setter functions
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Integer> getMarks() {
		return marks;
	}

}
