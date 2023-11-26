package com.hb07.fetchtypes;

import com.hb06.Book08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {

    public static void main(String[] args) {


         /*
        2.taraf Many ise default olarak Lazy , One ise default olarak EAGER yapar :
​
        OneToMany       --> LAZY
        ManyToMany      --> LAZY
        OneToOne        --> EAGER
        ManyToOne       --> EAGER
  */
        //--------------------------------------------------------------
        //--------------------------------------------------------------

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        Student09 student= session.get(Student09.class,1001);
        //System.out.println(student);

        Book09 book=session.get(Book09.class,101);
        //ManytoOne defaultta  EAGER olduğu için oalrak çalıştı
//        for(Book09 book : student.getBookList()){
//            System.out.println(book);
//        }


        tx.commit();
        session.close();
//        for(Book09 book1 : student.getBookList()){
//            System.out.println(book);
//        } EAGER olursa bilgiler gelir
        //EAGER olmazsa session kapandıktan sonra LAZY exception verir
        sf.close();
        //--------------------------------------------------------------
        //--------------------------------------------------------------

    }
}
