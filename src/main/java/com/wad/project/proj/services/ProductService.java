package com.wad.project.proj.services;
import com.wad.project.proj.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product p);
}