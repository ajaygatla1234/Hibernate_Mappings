package com.gl.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main_All_Operations {
	
	public static void main(String[] args) {
        // Create Hibernate SessionFactory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Save Employee data (as per your existing code)
        saveEmployeeData(sessionFactory);

        // Retrieve Employee data
        retrieveEmployeeData(sessionFactory);

        // Delete Employee data
        deleteEmployeeData(sessionFactory);

        // Close SessionFactory
        sessionFactory.close();
    }

    private static void saveEmployeeData(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Create an Employee
            Employee employee = new Employee();
            employee.setFirstName("John Doe");
            session.persist(employee);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void retrieveEmployeeData(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            // Execute HQL query to retrieve Employee data
            List<Employee> employees = session.createQuery("FROM Employee", Employee.class).getResultList();

            // Print retrieved data
            System.out.println("Retrieved Employee Data:");
            for (Employee employee : employees) {
                System.out.println("ID: " + employee.getId() + ", Name: " + employee.getFirstName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteEmployeeData(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Retrieve Employee to delete (replace ID with actual ID)
            Employee employeeToDelete = session.get(Employee.class, 2); // Assuming ID is 1

            if (employeeToDelete != null) {
                session.delete(employeeToDelete);
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
