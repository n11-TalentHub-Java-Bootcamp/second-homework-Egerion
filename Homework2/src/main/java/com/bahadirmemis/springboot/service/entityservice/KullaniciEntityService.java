package com.bahadirmemis.springboot.service.entityservice;

import com.bahadirmemis.springboot.dao.KullaniciDao;
import com.bahadirmemis.springboot.entity.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class KullaniciEntityService {

    @Autowired
    private KullaniciDao kullaniciDao;

    public List<Kullanici> findAll(){ return (List<Kullanici>) kullaniciDao.findAll();}

    public List<Kullanici> findAllByKullaniciById(Long kullaniciId){
        return kullaniciDao.findAllByKullaniciById(kullaniciId);
    }

    public List<Kullanici> findAllKullaniciByKullaniciName(String kullaniciAdi){
        return kullaniciDao.findAllKullaniciByKullaniciName(kullaniciAdi);
    }

    public List<Kullanici> findAllKullaniciByTelefon(String kullaniciTelefon){
        return kullaniciDao.findAllKullaniciByTelefon(kullaniciTelefon);
    }

    public Kullanici save(Kullanici kullanici){
        kullanici = kullaniciDao.save(kullanici);
        return kullanici;
    }

    public String deleteKullanici(@PathVariable String kullaniciAdi, String telefon){
        String result = "kullanıcı silindi";
        List<Kullanici> kullaniciList = kullaniciDao.findAllKullaniciByKullaniciAdiAndTelefon(kullaniciAdi, telefon);
        if(kullaniciList.isEmpty())
            result = "kullanıcı adı: " + kullaniciAdi + " ve telefon bilgisi: " + telefon + " olan bir kullanıcı bulunamadı...";
        else
            for (Kullanici kullanici : kullaniciList) {
                kullaniciDao.delete(kullanici);
            }
        return result;
    }

    public Kullanici updateKullaniciInfo(Long id, String adi, String soyadi, String email,
                                         String telefon, String kullaniciAdi){
        return kullaniciDao.updateKullaniciInfo(id, adi, soyadi, email,telefon,kullaniciAdi);
    }
}
