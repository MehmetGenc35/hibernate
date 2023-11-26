package com.hb05.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration con= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student06.class)
                .addAnnotatedClass(Book06.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx= session.beginTransaction();

//        Student06 student1= session.get(Student06.class,1001);
//        System.out.println(student1);

        //id si 101 olan kitabı HQL ile getir
        String hqlQuery="FROM Book06 b WHERE b.id=101";
        Book06 book1 = session.createQuery(hqlQuery,Book06.class).uniqueResult();
        System.out.println(book1);
        //id si 101 olan kitabı get methodu ile getir
//        Book06 book2=session.get(Book06.class,101);
//        System.out.println(book2);

        //id si 1001 olan öğrencinin kitaplarını HQL ile getir
        String hqlQuery2="SELECT b.id,b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id=1001";
        List<Object[]> resultList = session.createQuery(hqlQuery2).getResultList();
        for (Object[] w: resultList ) {
            System.out.println(Arrays.toString(w));
        }
        System.out.println("-".repeat(100));
        Student06 student2=session.get(Student06.class,1001);
        student2.getBookList().forEach(System.out::println);

        tx.commit();
        session.close();
        sf.close();



    }
}
