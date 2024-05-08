package com.gl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Student student1 = new Student("Sam", "Disilva");
		Student student2 = new Student("Joshua", "Brill");

		Subject subject1 = new Subject("Economics");
		Subject subject2 = new Subject("Politics");
		Subject subject3 = new Subject("Foreign Affairs");

		//Student1 have 3 subjects
		subject1.getStudents().add(student1);
		subject1.getStudents().add(student2);
		subject1.getStudents().add(student1);


		//Student2 have 2 subjects
		subject2.getStudents().add(student1);
		subject2.getStudents().add(student2);

		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("Factory object created...before opening session");
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Inserting Records...");
		session.persist(subject1);
		session.persist(subject2);

		session.getTransaction().commit();
		session.close();
	}
}
