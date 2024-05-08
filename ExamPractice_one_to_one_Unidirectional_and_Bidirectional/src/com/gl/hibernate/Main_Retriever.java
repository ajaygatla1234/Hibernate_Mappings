package com.gl.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_Retriever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		 Session session = sessionFactory.openSession();
		List<Employee> employees = session.createQuery("FROM Employee", Employee.class).getResultList();

        // Print retrieved data
        System.out.println("Retrieved Employee Data:");
        for (Employee employee : employees) {
            //System.out.println("ID: " + employee.getId() + ", Name: " + employee.getFirstName() +", City : "+ employee.address.getCity());
        	
        	System.out.println(employee.toString());
        }
        
	}
}
