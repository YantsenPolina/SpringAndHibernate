package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Instructor;
import com.polinayantsen.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalGetDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            int instructorDetailId = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
            System.out.println("Instructor by InstructorDetail with ID #" + instructorDetailId + ": " + instructorDetail.getInstructor());
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
