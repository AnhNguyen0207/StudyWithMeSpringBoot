package com.example.ex9_consumer.repository;

import com.example.ex9_consumer.entity.TongSlSpKho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SlSanPhamKhoRepo extends JpaRepository<TongSlSpKho,Integer> {
    @Query(value = "call total_sanpham_kho(?1) ", nativeQuery = true)
    int selectSanPhamKho(int id);
}
