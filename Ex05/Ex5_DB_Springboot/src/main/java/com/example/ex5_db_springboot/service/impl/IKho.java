package com.example.ex5_db_springboot.service.impl;

import com.example.ex5_db_springboot.service.IBase;
import com.example.ex5_db_springboot.model.Kho;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import org.springframework.stereotype.Service;
import java.util.List;

@EnableAutoConfiguration
@Service("Kho")
public class IKho implements IBase<Kho> {

    private final JdbcTemplate jdbcTemplate;

    public IKho (JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Kho> getAll() {
        String sql = "select * from kho";
        List<Kho> khos = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Kho.class));
        return khos;
    }

    @Override
    public void create(Kho kho) {
        MapSqlParameterSource in = new MapSqlParameterSource();
        try{
            in.addValue("ma_kho",kho.getMaKho());
            in.addValue("ten",kho.getTen());
            in.addValue("dia_diem",kho.getDiaDiem());
            in.addValue("ngay_tao",java.time.LocalDateTime.now());
            in.addValue("ngay_sua",java.time.LocalDateTime.now());
            String sql = "insert into  kho (ma_kho,ten,dia_diem,ngay_tao,ngay_sua) values (:ma_kho,:ten,:dia_diem,:ngay_tao,:ngay_sua)";
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            namedParameterJdbcTemplate.update(sql,in);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}

