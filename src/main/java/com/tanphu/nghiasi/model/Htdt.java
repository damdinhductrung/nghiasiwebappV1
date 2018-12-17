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
@Table(name = "htdt")
@EntityListeners(AuditingEntityListener.class)
public class Htdt implements Serializable {

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

    private String diaChi;

    private String dienThoai;

    private String giaoHo;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "khoi_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "khoi_id", nullable = false)
    private Khoi khoi;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "role_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "toan_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "toan_id", nullable = false)
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

    public void setTenThanh(String tenThah) {
        this.tenThanh = tenThah;
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

    public Khoi getKhoi() {
        return khoi;
    }

    public void setKhoi(Khoi khoi) {
        this.khoi = khoi;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Toan getToan() {
        return toan;
    }

    public void setToan(Toan toan) {
        this.toan = toan;
    }
}
