package com.hb01.annotations;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunerSave01 {

    public static void main(String[] args) {

        Student01 student1 = new Student01();
        student1.setId(1001);
        student1.setName("Fatma Ersoz");
        student1.setGrade(90);

        Student01 student2 = new Student01();
        student2.setId(1002);
        student2.setName("Omer Faruk Ekici");
        student2.setGrade(90);

        Student01 student3 = new Student01();
        student3.setId(1003);
        student3.setName("Fatih Azimetli");
        student3.setGrade(90);

        Configuration con= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();

        Transaction tx =session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();

        session.close();
        sf.close();

        //!!! Hibernate'e konfigurasyon ve entity siniflarimi gosteriyorum
//        Configuration con =
//                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
//
//        SessionFactory sf = con.buildSessionFactory();
//        Session session =  sf.openSession();
//
//        Transaction tx =  session.beginTransaction();
//
//        session.save(student1);
//        session.save(student2);
//        session.save(student3);
//
//        tx.commit();
//
//        session.close();
//        sf.close();
    }
}
