package com.bahadirmemis.springboot.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="URUNYORUM")
public class UrunYorum {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "YORUM", length = 500)
    private String yorum;
    @Column(name = "YORUM_TARIHI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date yorumTarihi;
    @Column(name = "URUN_ID", nullable = false)
    private Long urunId;
    @Column(name = "KULLANICI_ID", nullable = false)
    private Long kullaniciId;

    public Long getKullaniciId() {
        return kullaniciId;
    }
    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }
    public String getYorum() {
        return yorum;
    }
    public void setYorum(String yorum) {
        this.yorum = yorum;
    }
    public Date getYorumTarihi() {
        return yorumTarihi;
    }
    public void setYorumTarihi(Date yorumTarihi) {
        this.yorumTarihi = yorumTarihi;
    }
    public Long getUrunId() {
        return urunId;
    }
    public void setUrunId(Long urunId) {
        this.urunId = urunId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Kategori{" +
                "id=" + id +
                ", yorum='" + yorum + '\'' +
                ", urunId=" + urunId +
                ", kullaniciId=" + kullaniciId +
                '}';
    }
}
