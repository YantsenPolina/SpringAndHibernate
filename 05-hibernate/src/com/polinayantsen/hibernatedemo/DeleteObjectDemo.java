package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteObjectDemo {

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
            System.out.println("Deleting Student object with the ID #" + studentId);
            session.delete(student);
            System.out.println("Deleting Student object with the ID #" + 3);
            session.createQuery("DELETE FROM Student s WHERE s.id = 3").executeUpdate();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
