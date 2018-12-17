package com.tanphu.nghiasi.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "toan")
@EntityListeners(AuditingEntityListener.class)
public class Toan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String ten;

    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    private Date quanThay;

    @NotBlank
    @Lob
    private String tieuSu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getQuanThay() {
        return quanThay;
    }

    public void setQuanThay(Date quanThay) {
        this.quanThay = quanThay;
    }

    public String getTieuSu() {
        return tieuSu;
    }

    public void setTieuSu(String tieuSu) {
        this.tieuSu = tieuSu;
    }
}
