package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            int courseId = 10;
            int studentId = 1;
            Course course = session.get(Course.class, courseId);
            Student student = session.get(Student.class, studentId);
            session.delete(course);
            session.delete(student);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
