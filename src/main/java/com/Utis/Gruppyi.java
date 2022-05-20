package com.Utis;


import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "gruppyi", uniqueConstraints = @UniqueConstraint(columnNames = "Nazvanie"))
public class Gruppyi implements java.io.Serializable {

    private Integer shifr;
    private String nazvanie;
    private Date dataFormir;
    private Integer kodPlana;
    private String status;
    private Date statusDate;
    private List<Studentyi> studentyis = new LinkedList<>();
    private List<Predmetyi> predmetyi = new LinkedList<>();

    public Gruppyi() {
    }


    public Gruppyi(String nazvanie, Date dataFormir, Integer kodPlana) {
        this.nazvanie = nazvanie;
        this.dataFormir = dataFormir;
        this.kodPlana = kodPlana;
    }

    public Gruppyi(String nazvanie, Date dataFormir, Integer kodPlana, String status, Date statusDate, List<Studentyi> studentyis) {
        this.nazvanie = nazvanie;
        this.dataFormir = dataFormir;
        this.kodPlana = kodPlana;
        this.status = status;
        this.statusDate = statusDate;
        this.studentyis = studentyis;
    }

    @Id
//    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Shifr", unique = true, nullable = false)
    public Integer getShifr() {
        return this.shifr;
    }

    public void setShifr(Integer shifr) {
        this.shifr = shifr;
    }

    @Column(name = "Nazvanie", unique = true, nullable = false, length = 50)
    public String getNazvanie() {
        return this.nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DataFormir", nullable = false, length = 10)
    public Date getDataFormir() {
        return this.dataFormir;
    }

    public void setDataFormir(Date dataFormir) {
        this.dataFormir = dataFormir;
    }

    @Column(name = "kodPlana", length = 50)
    public Integer getKodPlana() {
        return this.kodPlana;
    }

    public void setKodPlana(Integer kodPlana) {
        this.kodPlana = kodPlana;
    }

    @Column(name = "Status", length = 50)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate", length = 10)
    public Date getStatusDate() {
        return this.statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gruppyi", cascade = {CascadeType.ALL})
    public List<Studentyi> getStudentyis() {
        return this.studentyis;
    }

    public void setStudentyis(List<Studentyi> studentyis) {
        this.studentyis = studentyis;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gruppyi")
    public List<Predmetyi> getPredmetyi() {
        return predmetyi;
    }

    public void setPredmetyi(List<Predmetyi> predmetyi) {
        this.predmetyi = predmetyi;
    }
}


