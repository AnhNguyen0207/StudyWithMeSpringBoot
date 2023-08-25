package com.example.ex09_poducer.controller;


import com.example.ex09_poducer.entity.Category;
import com.example.ex09_poducer.service.BaseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class CategoryController {

    private final BaseService<Category> categoryService;

    public CategoryController(@Qualifier("Category") BaseService<Category> categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/categories")
    public List<Category> getAllCategories()
    {
            return categoryService.getAll();
    }

    @GetMapping("/admin/category/{id}")
    public Category findById(@PathVariable @Valid int id)
    {
        return categoryService.findById(id);
    }

    @PostMapping("/admin/category")
    public Category create(@RequestBody @Valid Category category)
    {
        return categoryService.add(category);
    }

    @PutMapping("/admin/category/{id}")
    public Category updateById(@RequestBody @Valid Category category, @PathVariable @Valid int id)
    {
            return categoryService.updateById(category, id);
    }

    @DeleteMapping("/admin/category/delete/{id}")
    public String deleteById(@PathVariable @Valid int id)
    {
        categoryService.deleteById(id);
        return "Delete Success";
    }

    @GetMapping("/admin/categories/name")
    public List<Category> getAllCategoriesByName(@RequestParam("ten") String ten,
                                                @RequestParam(value = "page", required = false) Integer page,
                                                @RequestParam(value = "limit", required = false) Integer limit)
    {
        if (page != null && limit != null) {
            Pageable pageable = PageRequest.of(page - 1, limit);
            return categoryService.getAllByNamePage(ten, pageable);
        }else
        {
            return categoryService.getAllByNamePage(ten,null);
        }
    }
}
