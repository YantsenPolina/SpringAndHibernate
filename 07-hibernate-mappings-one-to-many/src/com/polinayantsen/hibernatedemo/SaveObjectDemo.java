package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Course;
import com.polinayantsen.hibernatedemo.entity.Instructor;
import com.polinayantsen.hibernatedemo.entity.InstructorDetail;
import com.polinayantsen.hibernatedemo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveObjectDemo {

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
            Instructor instructor = new Instructor("Arya", "Stark", "arya.stark@gmail.com");
            InstructorDetail instructorDetail =
                    new InstructorDetail("www.youtube.com/arya", "Dancing with a sword");
            instructor.setInstructorDetail(instructorDetail);
            Course courseOne = new Course("Sword Dancing");
            Course courseTwo = new Course("Changing Faces");
            instructor.addCourse(courseOne);
            instructor.addCourse(courseTwo);
            courseOne.addReview(new Review("Awesome!"));
            courseOne.addReview(new Review("Incredible!"));
            courseTwo.addReview(new Review("Fantastic!"));
            session.beginTransaction();
            session.save(courseOne);
            session.save(courseTwo);
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
