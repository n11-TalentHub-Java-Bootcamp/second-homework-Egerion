package com.bahadirmemis.springboot.controller;

import com.bahadirmemis.springboot.entity.Kullanici;
import com.bahadirmemis.springboot.service.entityservice.KullaniciEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kullanici")
public class KullaniciController {

    @Autowired
    private KullaniciEntityService kullaniciEntityService;

    //soru 2.1: Tüm kullanıcıları getiren bir servis yazınız
    @GetMapping("/liste")
    public List<Kullanici> findAllKullanici(){
        List<Kullanici> kullaniciList = kullaniciEntityService.findAll();
        return kullaniciList;
    }

    //sorun 2.2: Kullanıcı adından kullanıcıyı getiren bir servis yazınız.
    @GetMapping("/adi/{kullaniciAdi}")
    public List<Kullanici> findKullaniciByAdi(@PathVariable String kullaniciAdi){
        List<Kullanici> kullaniciList = kullaniciEntityService.findAllKullaniciByKullaniciName(kullaniciAdi);
        return kullaniciList;
    }

    //sorun 2.3: Kullanıcı telefonundan Kulanıcıyı getiren bir servis yazınız.
    @GetMapping("/telefon/{kullaniciTelefon}")
    public List<Kullanici> findKullaniciByTelefon(@PathVariable String kullaniciTelefon){
        List<Kullanici> kullaniciList = kullaniciEntityService.findAllKullaniciByTelefon(kullaniciTelefon);
        return kullaniciList;
    }

    //soru 2.4.Kullanıcı kaydedilebilecek bir servis yazınız.
    @PostMapping("")
    public Kullanici saveKullanici(@RequestBody Kullanici kullanici){
        kullanici = kullaniciEntityService.save(kullanici);
        return kullanici;
    }

    //2.5.Kullanıcı silebilecek bir servis yazınız. (kullanıcı adı, ve telefon bilgileri alınmalı). Eğer kullanıcı
    @DeleteMapping("/silme/{kullaniciAdi}/{telefon}")
    public String deleteKullaniciByKullaniciAdiAndTelefon(@PathVariable String kullaniciAdi, @PathVariable String telefon){
        return kullaniciEntityService.deleteKullanici(kullaniciAdi, telefon);
    }

    //2.6.Kullanıcı bilgilerini güncelleyebilecek bir servis yazınız.
    @PatchMapping("/guncelle/{id}/{adi}/{soyadi}/{email}/{telefon}/{kullaniciAdi}")
    public Kullanici updateKullaniciInfo(@PathVariable Long id, @PathVariable String adi, @PathVariable String soyadi, @PathVariable String email,
                                         @PathVariable String telefon, @PathVariable String kullaniciAdi){
        return kullaniciEntityService.updateKullaniciInfo(id,adi, soyadi, email,telefon, kullaniciAdi);
    }


}
