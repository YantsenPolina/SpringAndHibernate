package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Course;
import com.polinayantsen.hibernatedemo.entity.Instructor;
import com.polinayantsen.hibernatedemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            int instructorId = 1;
            Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i " +
                    "JOIN FETCH i.courses " +
                    "WHERE i.id =: instructorId", Instructor.class);
            query.setParameter("instructorId", instructorId);
            Instructor instructor = query.getSingleResult();
            System.out.println("Instructor: " + instructor);
            session.getTransaction().commit();
            session.close();
            System.out.println("Session is closed.");
            System.out.println("Courses: " + instructor.getCourses());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
