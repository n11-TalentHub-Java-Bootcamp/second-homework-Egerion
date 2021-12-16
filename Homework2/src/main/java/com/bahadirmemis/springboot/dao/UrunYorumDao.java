package com.bahadirmemis.springboot.dao;

import com.bahadirmemis.springboot.entity.UrunYorum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrunYorumDao extends CrudRepository<UrunYorum, Long> {

    @Query("select urunYorum from UrunYorum urunYorum where urunYorum.kullaniciId = :kullaniciId")
    List<UrunYorum> findAllUrunYorumByKullaniciId(Long kullaniciId);

    @Query("select urunYorum from UrunYorum urunYorum where urunYorum.urunId = :urunId")
    List<UrunYorum> findAllUrunYorumByUrunId(Long urunId);

    @Query("select urunYorum from UrunYorum urunYorum where urunYorum.urunId = :urunId")
    UrunYorum findUrunYorumById(Long urunId);

}
