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

    public void addStudentAndCourse() {
        Student student = new Student("李白");
        em.persist(student);
        Student student1 = new Student("杜甫");
        em.persist(student1);

        Course course = new Course("数学");
        em.persist(course);
        Course course1 = new Course("英语");
        em.persist(course1);
    }

    public void addElective(){
        var s1=em.find(Student.class,13);
        var c1=em.find(Course.class,14);

        Elective elective=new Elective();
        elective.setStudent(s1);
        elective.setCourse(c1);
        em.persist(elective);

        var s2=em.find(Student.class,14);
        var c2=em.find(Course.class,13);

        Elective elective1=new Elective();
        elective1.setStudent(s2);
        elective1.setCourse(c2);
        em.persist(elective1);
    }
}
