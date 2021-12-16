package com.bahadirmemis.springboot.service.entityservice;

import com.bahadirmemis.springboot.dao.UrunYorumDao;
import com.bahadirmemis.springboot.entity.Urun;
import com.bahadirmemis.springboot.entity.UrunYorum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrunYorumEntityService {

    @Autowired
    private UrunYorumDao urunYorumDao;

    public List<UrunYorum> findAll(){ return (List<UrunYorum>) urunYorumDao.findAll();}

    //3.1.Bir kullanıcının yaptığı yorumlari getiren bir servis yazınız. Eğer ilgili kullanıcının henüz bir
    public List<UrunYorum> findAllUrunYorumByKullaniciId(Long kullaniciId){
        return urunYorumDao.findAllUrunYorumByKullaniciId(kullaniciId);
    }

    //3.2.Bir ürüne yapılan tüm yorumları getiren bir servis yazınız. Eğer o ürüne henüz bir yorum
    //yazılmamışsa “XXX ürüne henüz bir yorum yazılmamıştır” şeklinde bir uyarı vermeli.
    public List<UrunYorum> findAllUrunYorumByUrunId(Long urunId){
        return urunYorumDao.findAllUrunYorumByUrunId(urunId);
    }

    //3.3.Yeni bir yorum yazılabilecek bir servis yazınız.
    public UrunYorum saveYorum(UrunYorum urunYorum){
        return urunYorumDao.save(urunYorum);
    }

    //3.4.Yorum silebilecek bir servis yazınız.
    public String deleteUrunYorumById(Long urunId){
        String result = "yorum silindi";
        UrunYorum urunYorum = urunYorumDao.findUrunYorumById(urunId);
        if(urunYorum == null){
            urunYorumDao.delete(urunYorum);
        }
        else{
            result = "yorum bulunamadı";
        }
        return result;
    }
}
