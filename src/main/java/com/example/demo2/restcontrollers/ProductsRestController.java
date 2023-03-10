package com.example.demo2.restcontrollers;

import com.example.demo2.beans.Product;
import com.example.demo2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductsRestController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/hplus/rest/products")
    @ResponseBody
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }
}
