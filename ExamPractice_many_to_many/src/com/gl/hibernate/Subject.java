package com.gl.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT")
public class Subject {

	@Id
	@GeneratedValue
	@Column(name = "SUBJECT_ID")
	private long id;

	@Column(name="NAME")
	private String name;

	//	@ManyToMany(mappedBy = "subjects")
	//	private List<Student> students = new ArrayList<Student>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="STUDENT_SUBJECT", 
	joinColumns = {@JoinColumn(name = "SUBJECT_ID")},
	inverseJoinColumns = {@JoinColumn(name = "STUDENT_ID")}
			)
	private List<Student> students = new ArrayList<Student>();


	public Subject() {
		super();
	}


	public Subject(String name) {
		super();
		this.name = name;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", students=" + students + "]";
	}

}
