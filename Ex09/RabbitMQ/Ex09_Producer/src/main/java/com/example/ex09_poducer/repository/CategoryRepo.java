package com.example.ex09_poducer.repository;

import com.example.ex09_poducer.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
    Category findOneById(int id);

    @Query(value = "call delete_danh_muc_by_id(?1)" ,nativeQuery = true)
    int deleteById(int id);

    @Query("select c from Category c where c.ten like %?1%")
    List<Category> getByNamePage(String ten, Pageable pageable);
}

