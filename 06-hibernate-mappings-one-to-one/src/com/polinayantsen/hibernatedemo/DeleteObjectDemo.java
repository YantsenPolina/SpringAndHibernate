package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Instructor;
import com.polinayantsen.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteObjectDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            Instructor instructor = new Instructor("Daenerys", "Targaryen", "daenerys.targaryen@gmail.com");
            InstructorDetail instructorDetail =
                    new InstructorDetail("www.youtube.com/daenerys", "Flying on a dragon");
            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            int instructorId = 1;
            Instructor instructorFromDB = session.get(Instructor.class, instructorId);
            if (instructorFromDB != null) {
                session.delete(instructorFromDB);
            }
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
