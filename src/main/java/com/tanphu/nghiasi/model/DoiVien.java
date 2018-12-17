package com.tanphu.nghiasi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "doiVien")
@EntityListeners(AuditingEntityListener.class)
public class DoiVien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String tenThanh;

    @NotBlank
    private String ho;

    @NotBlank
    private String ten;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySinh;

    @Temporal(TemporalType.TIMESTAMP)
    private Date quanThay;

    private String tenCha;

    private String tenMe;

    private String diaChi;

    private String dienThoai;

    private String giaoHo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "toan_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Toan toan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenThanh() {
        return tenThanh;
    }

    public void setTenThanh(String tenThanh) {
        this.tenThanh = tenThanh;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getQuanThay() {
        return quanThay;
    }

    public void setQuanThay(Date quanThay) {
        this.quanThay = quanThay;
    }

    public String getTenCha() {
        return tenCha;
    }

    public void setTenCha(String tenCha) {
        this.tenCha = tenCha;
    }

    public String getTenMe() {
        return tenMe;
    }

    public void setTenMe(String tenMe) {
        this.tenMe = tenMe;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getGiaoHo() {
        return giaoHo;
    }

    public void setGiaoHo(String giaoHo) {
        this.giaoHo = giaoHo;
    }

    public Toan getToan() {
        return toan;
    }

    public void setToan(Toan toan) {
        this.toan = toan;
    }
}
