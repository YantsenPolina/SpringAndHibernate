package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class SaveObjectDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            System.out.println("Creating new Student object...");
            String dateOfBirthStr = "28/01/1990";
            Date dateOfBirth = DateUtils.parseDate(dateOfBirthStr);
            Student student = new Student("Bart", "Simpson", "bart.simpson@gmail.com", dateOfBirth);
            session.beginTransaction();
            System.out.println("Saving Student object to the database...");
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Student object is saved to the database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
