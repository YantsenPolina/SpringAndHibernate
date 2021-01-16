package com.polinayantsen.hibernatedemo;

import com.polinayantsen.hibernatedemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            List<Student> students = session.createQuery("FROM Student").getResultList();
            System.out.println("All Students: ");
            printStudents(students);

            students = session.createQuery("FROM Student s WHERE s.lastName = 'Greyjoy'").getResultList();
            System.out.println("All Students with Greyjoy last name: ");
            printStudents(students);

            students = session.createQuery("FROM Student s WHERE s.lastName = 'Greyjoy' OR s.firstName = 'Daenerys'").getResultList();
            System.out.println("All Students with Greyjoy last name or with Daenerys first name: ");
            printStudents(students);

            students = session.createQuery("FROM Student s WHERE s.email LIKE '%gmail.com'").getResultList();
            System.out.println("All Students with gmail.com email: ");
            printStudents(students);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
