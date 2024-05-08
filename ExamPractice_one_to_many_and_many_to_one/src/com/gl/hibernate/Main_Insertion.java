package com.gl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_Insertion {

	public static void main(String[] args) {
		
		Department department1 = new Department("IT");
		Department department2 = new Department("HR");
		
		Employee employee1 = new Employee("Ajay", department2);
		Employee employee2 = new Employee("Subbu", department1);
		
		department1.getEmployees().add(employee2);
		department2.getEmployees().add(employee1);
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=null;
		
		try{
			session=sessionFactory.openSession();
			session.beginTransaction();
			session.persist(department1);
			session.persist(department2);
			session.getTransaction().commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}
	}
}
