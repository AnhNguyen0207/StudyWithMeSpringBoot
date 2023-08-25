package com.example.ex5_db_springboot.repository;

import com.example.ex5_db_springboot.entity.KhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface KhoRepository extends JpaRepository<KhoEntity,Long>{
}
