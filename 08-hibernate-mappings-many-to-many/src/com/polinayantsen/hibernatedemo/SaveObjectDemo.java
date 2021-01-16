package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class SaveObjectDemo {

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
            Student studentOne = new Student("Bart", "Simpson", "bart.simpson@gmail.com");
            Student studentTwo = new Student("Homer", "Simpson", "homer.simpson@gmail.com");
            courseOne.addStudent(studentOne);
            courseTwo.addStudent(studentTwo);
            studentOne.addCourse(courseTwo);
            session.beginTransaction();
            session.save(courseOne);
            session.save(courseTwo);
            session.save(instructor);
            session.save(studentOne);
            session.save(studentTwo);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
