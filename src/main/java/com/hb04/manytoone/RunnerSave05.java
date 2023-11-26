package com.hb04.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {

    public static void main(String[] args) {

        Student05 student01=new Student05();
        student01.setId(1001);
        student01.setName("Zafer Hoca");
        student01.setGrade(10);


        Student05 student02=new Student05();
        student02.setId(1002);
        student02.setName("Yusuf Hoca");
        student02.setGrade(9);

        Student05 student03=new Student05();
        student03.setId(1003);
        student03.setName("Yiğit Hoca");
        student03.setGrade(8);

        University university=new University();
        university.setId(1);
        university.setName("TPE Unv");

        student01.setUniversity(university);
        student02.setUniversity(university);
        student03.setUniversity(university);

        Configuration con= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student05.class)
                .addAnnotatedClass(University.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx =session.beginTransaction();

        session.save(university);
        session.save(student01);
        session.save(student02);
        session.save(student03);



        tx.commit();
        session.close();
        sf.close();

    }



}
