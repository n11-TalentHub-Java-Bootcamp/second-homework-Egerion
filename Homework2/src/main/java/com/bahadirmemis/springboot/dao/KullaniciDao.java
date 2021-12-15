package com.bahadirmemis.springboot.dao;

import com.bahadirmemis.springboot.entity.Kullanici;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface KullaniciDao extends CrudRepository<Kullanici, Long> {

    @Query("select kullanici from Kullanici kullanici where kullanici.id = :kullaniciId")
    List<Kullanici> findAllByKullaniciById(Long kullaniciId);

    @Query("select kullanici from Kullanici kullanici where kullanici.adi = :kullaniciAdi")
    List<Kullanici> findAllKullaniciByKullaniciName(String kullaniciAdi);

    @Query("select kullanici from Kullanici kullanici where kullanici.telefon = :kullaniciTelefon")
    List<Kullanici> findAllKullaniciByTelefon(String kullaniciTelefon);

    @Query("select kullanici from Kullanici  kullanici where kullanici.kullaniciAdi = :adi and kullanici.telefon = :kullaniciTelefon")
    List<Kullanici> findAllKullaniciByKullaniciAdiAndTelefon(String adi, String kullaniciTelefon);

    @Query("update Kullanici kullanici " +
            "set kullanici.adi = :adi, kullanici.soyadi = :soyadi, kullanici.email = :email, " +
            "kullanici.telefon =:telefon, kullanici.kullaniciAdi = :kullaniciAdi " +
            "where kullanici.id = :id")
    Kullanici updateKullaniciInfo(Long id, String adi, String soyadi, String email,
                                  String telefon, String kullaniciAdi);
}
