package com.hb10.life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("-----> session.get cagrildi");
        Employee emp1 = session.get(Employee.class, 1L);

        System.out.println("-----> session.delete cagrildi");
        session.delete(emp1);

        tx.commit();
        session.close();
        sf.close();
    }
}
