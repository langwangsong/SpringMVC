package org.fkit.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	private List<String> courses;

	public User() {
		super();
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
}
