package com.runner;

import com.Utis.NewHibernateUtil;
import com.tasks.Task1;
import com.tasks.Task2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Task1 task1 = new Task1(s);
        task1.readOtchislen("otchislen");
        task1.readByStudetyiDate(4);
        Task2 task2 = new Task2(s);
        task2.detachGruppyi(6);

        s.close();
        sf.close();
    }

}
