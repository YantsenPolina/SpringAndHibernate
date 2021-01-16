package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            System.out.println("Creating Student objects...");
            Student studentOne = new Student("Arya", "Stark", "arya.stark@gmail.com");
            Student studentTwo = new Student("Jon", "Snow", "jon.snow@gmail.com");
            Student studentThree = new Student("Yara", "Greyjoy", "yara.greyjoy@gmail.com");
            session.beginTransaction();
            System.out.println("Saving Student objects to the database...");
            session.save(studentOne);
            session.save(studentTwo);
            session.save(studentThree);
            session.getTransaction().commit();
            System.out.println("Student objects are saved to the database.");
        } finally {
            sessionFactory.close();
        }
    }
}
