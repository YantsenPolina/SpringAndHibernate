package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateObjectDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            int studentId = 1;
            session.beginTransaction();
            System.out.println("Retrieving Student object with the ID #" + studentId);
            Student student = session.get(Student.class, studentId);
            System.out.println("Retrieved Student object: " + student);
            System.out.println("Updating Student object...");
            student.setFirstName("Homer");
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Updating email for Student with Simpson last name...");
            session.createQuery("UPDATE Student s SET s.email = 'example@gmail.com' WHERE s.lastName = 'Simpson'").executeUpdate();
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
