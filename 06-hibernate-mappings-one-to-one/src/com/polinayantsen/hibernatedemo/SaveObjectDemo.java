package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Instructor;
import com.polinayantsen.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveObjectDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            Instructor instructor = new Instructor("Arya", "Stark", "arya.stark@gmail.com");
            InstructorDetail instructorDetail =
                    new InstructorDetail("www.youtube.com/arya", "Dancing with a sword");
            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
