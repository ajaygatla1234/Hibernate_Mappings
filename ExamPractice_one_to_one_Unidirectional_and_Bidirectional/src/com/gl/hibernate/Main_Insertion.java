package com.gl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_Insertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create Hibernate SessionFactory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session=null;
        // Create an Employee
        Employee employee = new Employee();
        employee.setFirstName("John Doe");

        // Create an Address
        Address address = new Address();
        address.setCity("Hyderabad");

        // Associate Address with Employee
        employee.setAddress(address);
        
        try {
        	 // Save Employee (which cascades to Address)
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
        finally {
        	session.close();
        	// Close SessionFactory
            sessionFactory.close();
		}

	}

}
