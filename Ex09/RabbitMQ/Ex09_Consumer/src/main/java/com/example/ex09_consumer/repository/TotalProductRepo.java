package com.example.ex09_consumer.repository;

import com.example.ex09_consumer.entity.TongSlSpKho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalProductRepo extends JpaRepository<TongSlSpKho,Integer>{
}
