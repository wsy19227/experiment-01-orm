package com.example.springbootexperiment01.repository;

import com.example.springbootexperiment01.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ElectiveRepository {
    @PersistenceContext
    private EntityManager em;

    public void addElective() {
        Student student = new Student("思");
        em.persist(student);
        Student student1 = new Student("昭");
        em.persist(student1);

        Course course = new Course("设计模式");
        em.persist(course);
        Course course1 = new Course("xml");
        em.persist(course1);

        var s1=em.find(Student.class,11);
        var c1=em.find(Course.class,12);

        var s2=em.find(Student.class,12);
        var c2=em.find(Course.class,11);

        Elective elective=new Elective();
        elective.setStudent(s1);
        elective.setCourse(c1);
        em.persist(elective);

        Elective elective1=new Elective();
        elective1.setStudent(s2);
        elective1.setCourse(c2);

        em.persist(elective1);


    }
}
