package com.tasks;

import com.Utis.Studentyi;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class Task1 {
    private final Session s;

    public Task1(Session s) {
        this.s = s;
    }

    public void readOtchislen(String status) {
        Transaction t = s.beginTransaction();
        List<Studentyi> studs = s.createQuery("from Studentyi s where s.status = :status").setParameter("status", status).list();
        for (Studentyi stud : studs) {
            System.out.println(stud);
        }
        t.commit();
    }

    public void readByStudetyiDate(Integer year) {
        Transaction t = s.beginTransaction();
        year = LocalDate.now().minusYears(year).getYear();
        List<Studentyi> studs = s.createQuery("from Studentyi s where extract(year from s.statusDate) <= :year").setParameter("year",
                year).list();
        for (Studentyi stud : studs) {
            System.out.println(stud.getFamiliya() + " " + stud.getImya() + " " + stud.getOtchestvo() + ", Group: " + stud.getGruppyi().getNazvanie());
        }
        t.commit();
    }
}
