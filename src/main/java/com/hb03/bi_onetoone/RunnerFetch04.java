package com.hb03.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
/*
        Student04 student= session.get(Student04.class,1001);
        Diary04 diary=session.get(Diary04.class,101);

        System.out.println("---------------------------------------");
        System.out.println(student);
        System.out.println("---------------------------------------");
        System.out.println(diary);
        System.out.println("---------------------------------------");

        String hqlQuery=
                "SELECT s.name,d.name FROM Student04 s " +
                        "INNER JOIN FETCH Diary04 d ON s.id=d.student";
        //SQL==>SELECT s.name,d.name FROM student04 s INNER JOIN diary04 d ON s.id=d.std_id

        List<Object[]> resultList1= session.createQuery(hqlQuery).getResultList();
        for (Object[] w :resultList1  ) {
            System.out.println(Arrays.toString(w));
        }

        resultList1.forEach(t->{ // lambda expression
            System.out.println(Arrays.toString(t));
        });
        */

        //!!! HQL LEFT JOIN
        // Task: butun ogrenciler ve varsa bu ogrencilerin gunluk bilgileri gelsin
//        String hqlQuery2 = "SELECT s.name,d.name FROM Student04 s LEFT JOIN FETCH Diary04 d on s.id=d.student";
//        List<Object[]> resultList2 = session.createQuery(hqlQuery2).getResultList();
//        resultList2.forEach(oa->{
//            System.out.println(Arrays.toString(oa));
//        });

        // !!! HQL RIGHT JOIN
        // TASK: Butun gunlukler ve varsa gunlugu olan ogrenciler gelsin
//        String hqlQuery3 = "SELECT s.name,d.name FROM Student04 s RIGHT JOIN FETCH Diary04 d on s.id=d.student";
//        List<Object[]> resultList3 = session.createQuery(hqlQuery3).getResultList();
//        resultList3.forEach(oa->{
//            System.out.println(Arrays.toString(oa));
//        });

        //!!! HQL FULL JOIN
        // TASK : butun ogrenci ve diary ler gelsin
        String hqlQuery4 = "SELECT s.name,d.name FROM Student04 s FULL JOIN FETCH Diary04 d on s.id=d.student";
        List<Object[]> resultList4 = session.createQuery(hqlQuery4).getResultList();
        resultList4.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });



        tx.commit();
        session.close();
        sf.close();


    }
}
