package com.example.ex09_poducer.repository;

import com.example.ex09_poducer.entity.TongSlSpKho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalProductRepo extends JpaRepository<TongSlSpKho,Integer> {
    @Query(value = "call total_sanpham_kho(?1) " ,nativeQuery = true)
    String totalProduct(String id);
}
