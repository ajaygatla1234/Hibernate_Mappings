package com.gl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Employee employeeToDelete = session.get(Employee.class, 1); // Assuming ID is 1
		session.beginTransaction();
		if (employeeToDelete != null) {
			session.delete(employeeToDelete);
			System.out.println("Employee deleted successfully.");
		} else {
			System.out.println("Employee not found.");
		}

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	} 
	

}


