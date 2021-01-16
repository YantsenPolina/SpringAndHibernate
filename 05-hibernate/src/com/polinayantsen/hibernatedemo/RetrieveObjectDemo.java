package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveObjectDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            System.out.println("Creating new Student object...");
            Student student = new Student("Daenerys", "Targaryen", "daenerys.targaryen@gmail.com");
            session.beginTransaction();
            System.out.println("Saving Student object to the database...");
            System.out.println(student);
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Student object is saved to the database.");

            System.out.println("Saved Student ID: " + student.getId());
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Retrieving Student object with the ID #" + student.getId());
            Student studentFormDB = session.get(Student.class, student.getId());
            System.out.println("Retrieved Student object: " + studentFormDB);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
