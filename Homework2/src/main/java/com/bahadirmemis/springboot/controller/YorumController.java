package com.bahadirmemis.springboot.controller;

import com.bahadirmemis.springboot.converter.UrunYorumConverter;
import com.bahadirmemis.springboot.dao.UrunYorumDao;
import com.bahadirmemis.springboot.dto.KategoriDto;
import com.bahadirmemis.springboot.dto.UrunYorumDto;
import com.bahadirmemis.springboot.entity.UrunYorum;
import com.bahadirmemis.springboot.exception.UrunNotFoundException;
import com.bahadirmemis.springboot.exception.YorumNotFoundException;
import com.bahadirmemis.springboot.service.entityservice.UrunYorumEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yorum")
public class YorumController {

    @Autowired
    UrunYorumEntityService urunYorumEntityService;

    @GetMapping("/liste")
    public List<UrunYorum> findAll(){
        List<UrunYorum> urunYorumList = urunYorumEntityService.findAll();
        return urunYorumList;
    }

    //3.1.Bir kullanıcının yaptığı yorumlari getiren bir servis yazınız. Eğer ilgili kullanıcının henüz bir
    //yorumu yoksa “XXX kullanıcı henüz bir yorum yazmamıştır” şeklinde bir uyarı vermeli.
    @GetMapping("/kullanici/id/{kullaniciId}")
    public List<UrunYorum> findAllUrunYorumByKullaniciId(@PathVariable Long kullaniciId){
        String result;
        List<UrunYorum> urunYorumList = urunYorumEntityService.findAllUrunYorumByKullaniciId(kullaniciId);
        if(urunYorumList.isEmpty()){
            throw new YorumNotFoundException(kullaniciId + " Id'li kullanıcı henüz bir yorum yazmamıştır.");
        }
        return urunYorumList;
    }

    //3.2.Bir ürüne yapılan tüm yorumları getiren bir servis yazınız. Eğer o ürüne henüz bir yorum
    @GetMapping("/id/{urunId}")
    public List<UrunYorum> findAllUrunYorumByUrunId(@PathVariable Long urunId){
        List<UrunYorum> urunYorumList = urunYorumEntityService.findAllUrunYorumByUrunId(urunId);
        if(urunYorumList.isEmpty()){
            throw new YorumNotFoundException(urunId + "id'li ürüne henüz bir yorum yazılmamıştır");
        }
        return urunYorumList;
    }

    //3.3.Yeni bir yorum yazılabilecek bir servis yazınız.
    @PostMapping("")
    public UrunYorumDto save(@RequestBody UrunYorumDto urunYorumDto){

        UrunYorum urunYorum = UrunYorumConverter.INSTANCE.convertUrunYorumDtoToUrunYorum(urunYorumDto);
        UrunYorumEntityService.saveYorum(urunYorum);
    }

    //3.4.Yorum silebilecek bir servis yazınız.
    @DeleteMapping("/sil/{id}")
    public String deleteUrunYorumById(@PathVariable Long id){
        return urunYorumEntityService.deleteUrunYorumById(id);
    }

}
