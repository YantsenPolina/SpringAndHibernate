package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Course;
import com.polinayantsen.hibernatedemo.entity.Instructor;
import com.polinayantsen.hibernatedemo.entity.InstructorDetail;
import com.polinayantsen.hibernatedemo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            int instructorId = 1;
            Instructor instructor = session.get(Instructor.class, instructorId);
            System.out.println("Instructor: " + instructor);
            System.out.println("Courses by Instructor with ID #" + instructorId + ": " + instructor.getCourses());
            System.out.println("Reviews of the first course: " + instructor.getCourses().get(0).getReviews());
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
