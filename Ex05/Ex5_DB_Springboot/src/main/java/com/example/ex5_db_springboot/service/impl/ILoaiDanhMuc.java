package com.example.ex5_db_springboot.service.impl;


import com.example.ex5_db_springboot.model.LoaiDanhMuc;
import com.example.ex5_db_springboot.service.IBase;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("LoaiDanhMuc")
public class ILoaiDanhMuc implements IBase<LoaiDanhMuc> {

    private final JdbcTemplate jdbcTemplate;

    public  ILoaiDanhMuc (JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<LoaiDanhMuc> getAll() {
        String sql = "select * from loai_danh_muc";
        List<LoaiDanhMuc> loaiDanhMucs = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LoaiDanhMuc.class));
        return loaiDanhMucs;
    }

    @Override
    public void create(LoaiDanhMuc loaiDanhMuc) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        try {
            simpleJdbcInsert.withTableName("loai_danh_muc");
            Map<String,Object> parameters = new HashMap<>();
            parameters.put("ma_loai_danh_muc",loaiDanhMuc.getMaLoaiDanhMuc());
            parameters.put("ten",loaiDanhMuc.getTen());
            parameters.put("mo_ta",loaiDanhMuc.getMoTa());
            parameters.put("ngay_tao",java.time.LocalDateTime.now());
            parameters.put("ngay_sua",java.time.LocalDateTime.now());
            simpleJdbcInsert.execute(parameters);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


}
