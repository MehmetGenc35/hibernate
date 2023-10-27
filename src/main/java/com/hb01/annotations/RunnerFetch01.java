package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration con =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session =  sf.openSession();

        Transaction tx =  session.beginTransaction();

        // !!! DB den bilgi cekmek icin 3 yol :
                // 1) get metodu
                // 2) SQL
                // 3) HQL ( Hibernate Query Language )
        // Not: Get =============================================
//         Student01 student1 = session.get(Student01.class,1001);
//         Student01 student2 = session.get(Student01.class,1002);
//         System.out.println(student1);
//         System.out.println(student2);
//         System.out.println(student2.getName());

        // Not: SQL =============================================
//        String sqlQuery1 = "SELECT * FROM t_student01";
//        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//        for(Object[] objects: resultList1){
//            System.out.println(Arrays.toString(objects));
//        }

        // Not: HQL ============================================
//        String hqlQuery1 = "FROM Student01";
//        List<Student01> resultList3 =  session.createQuery(hqlQuery1, Student01.class).getResultList();
//        for(Student01 student01: resultList3){
//            System.out.println(student01);
//        }

//        String sqlQuery2="SELECT * FROM t_student01 WHERE student_name='Fatma Ersoz'";
//        Object[] uniqueResult1= (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//        System.out.println(Arrays.toString(uniqueResult1));

//        String hqlQuery2="FROM Student01 WHERE name='Fatma Ersoz'";
//        Student01 uniqueResult2=session.createQuery(hqlQuery2,Student01.class).uniqueResult();
//        System.out.println(uniqueResult2);

//        String hqlQuery3="SELECT id,name FROM Student01 WHERE grade=90";
//        List<Object[]> uniqueResult3 = session.createQuery(hqlQuery3).getResultList();
//        for (Object[] w:uniqueResult3) {
//            System.out.println(Arrays.toString(w));
//        }

        String hqlQuery5 = "FROM Student01 ORDER BY id DESC";
        List<Student01> resultList1= session.createQuery(hqlQuery5,Student01.class).getResultList();

        for (Student01 w :resultList1 ) {
            System.out.println(w);
        }




        tx.commit();

        session.close();
        sf.close();
    }
}
