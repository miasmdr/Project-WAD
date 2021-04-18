package com.wad.project.proj.services;
import com.wad.project.proj.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {
    List<Product> products = new ArrayList(List.of(
            new Product(15L, "car"),
            new Product(17L, "bike"),
            new Product(19L, "candy"),
            new Product(18L, "cookies")
    ));


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product p) {
        if(p.getId()==null)
            p.setId(new Random().nextLong());
        products.add(p);
    }
}