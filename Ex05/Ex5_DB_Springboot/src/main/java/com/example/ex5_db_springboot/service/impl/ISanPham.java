package com.example.ex5_db_springboot.service.impl;


import com.example.ex5_db_springboot.model.SanPham;
import com.example.ex5_db_springboot.service.IBase;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("SanPham")
public class ISanPham implements IBase<SanPham> {

    private final JdbcTemplate jdbcTemplate;
    public ISanPham(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<SanPham> getAll() {
        String sql = "select * from san_pham";
        List<SanPham> sanPhams = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SanPham.class));
        return sanPhams;
    }

    @Override
    public void create(SanPham sanPham) {

    }

}
