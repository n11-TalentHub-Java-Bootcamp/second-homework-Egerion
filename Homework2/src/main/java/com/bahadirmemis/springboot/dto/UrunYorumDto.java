package com.bahadirmemis.springboot.dto;

import com.bahadirmemis.springboot.entity.UrunYorum;
import com.fasterxml.jackson.annotation.JsonFilter;

import java.util.Date;

@JsonFilter("UrunYorumDtoFilter")
public class UrunYorumDto {

    private Long id;
    private String yorum;
    private Date yorumTarihi;
    private Long urunId;
    private Long kullaniciId;

    public UrunYorumDto(){

    }

    public UrunYorumDto(Long id, String yorum, Date yorumTarihi, Long urunId, Long kullaniciId) {
        this.id = id;
        this.yorum = yorum;
        this.yorumTarihi = yorumTarihi;
        this.urunId = urunId;
        this.kullaniciId = kullaniciId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    @Override
    public String toString() {
        return "UrunYorumDto{" +
                "id=" + id +
                ", yorum='" + yorum + '\'' +
                ", yorumTarihi=" + yorumTarihi +
                ", urunId=" + urunId +
                ", kullaniciId=" + kullaniciId +
                '}';
    }
}
