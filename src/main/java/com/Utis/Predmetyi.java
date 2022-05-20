package com.Utis;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "predmetyi")
public class Predmetyi {
    private Integer kodPredmeta;
    private String nazvanie;
    private Integer kolTchasov;
    private Gruppyi gruppyi;
    private Date statusDate;

    public Predmetyi(Integer kodPredmeta, String nazvanie, Integer kolTchasov, Gruppyi gruppyi, Date statusDate) {
        this.kodPredmeta = kodPredmeta;
        this.nazvanie = nazvanie;
        this.kolTchasov = kolTchasov;
        this.gruppyi = gruppyi;
        this.statusDate = statusDate;
    }

    public Predmetyi() {
    }

    @Id
    @Column(name = "kodPredmeta", nullable = false)
    public Integer getKodPredmeta() {
        return kodPredmeta;
    }

    public void setKodPredmeta(Integer kodPredmeta) {
        this.kodPredmeta = kodPredmeta;
    }

    @Column(name = "nazvanie", unique = true, nullable = false)
    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    @Column(name = "kolTchasov", nullable = false)
    public Integer getKolTchasov() {
        return kolTchasov;
    }

    public void setKolTchasov(Integer kolTchasov) {
        this.kolTchasov = kolTchasov;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShifrGruppyi", nullable = false)
    public Gruppyi getGruppyi() {
        return gruppyi;
    }

    public void setGruppyi(Gruppyi gruppyi) {
        this.gruppyi = gruppyi;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate", length = 10)
    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
}
