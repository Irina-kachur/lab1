package com.tasks;

import com.Utis.Gruppyi;
import com.Utis.Studentyi;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Task2 {
    private final Session s;

    public Task2(Session s) {
        this.s = s;
    }

    public void detachGruppyi(int count) {
        List<Gruppyi> gruppyis = s.createQuery("from Gruppyi g ").list();
        for (int i = 0; i < gruppyis.size(); i++) {
            if (gruppyis.get(i).getStudentyis().size() >= count) {
                Gruppyi gruppyi = new Gruppyi();
                replaceStudentiy(gruppyis.get(i), gruppyi);
                s.saveOrUpdate(gruppyis.get(i));
                s.saveOrUpdate(gruppyi);
                Transaction t = s.beginTransaction();
                for (Studentyi studentyi : gruppyi.getStudentyis()) {
                    studentyi.setGruppyi(gruppyi);
                    s.saveOrUpdate(studentyi);
                }
                t.commit();
                return;
            }
        }
    }

    private void replaceStudentiy(Gruppyi gr1, Gruppyi gr2) {
        gr2.setNazvanie(gr1.getNazvanie().concat("(2)"));
        gr1.setNazvanie(gr1.getNazvanie().concat("(1)"));
        gr2.setDataFormir(gr1.getDataFormir());
        gr2.setStatus(gr1.getStatus());
        gr2.setKodPlana(gr1.getKodPlana());
        gr2.setShifr(gr1.getShifr() + 1);
        int count = gr1.getStudentyis().size() / 2;
        int countStudetyi = gr1.getStudentyis().size();
        for (int i = countStudetyi - 1; i >= count; i--) {
            gr2.getStudentyis().add(gr1.getStudentyis().get(i));
        }
        for (int i = countStudetyi - 1; i >= count; i--) {
            gr1.getStudentyis().remove(i);
        }
        Transaction t = s.beginTransaction();
        s.save(gr2);
        t.commit();
    }
}
