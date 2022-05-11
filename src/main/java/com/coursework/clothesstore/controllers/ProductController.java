package com.coursework.clothesstore.controllers;


import com.coursework.clothesstore.models.Product;
import com.coursework.clothesstore.models.ProductType;
import com.coursework.clothesstore.services.ProductService;
import com.coursework.clothesstore.services.ProductTypeService;
import com.coursework.clothesstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String Product(Model model) {
        Iterable<Product> product = productService.getAll();
        model.addAttribute("product", product);
        return "products";
    }

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public String getProduct(@PathVariable("id") Long id, Model model) {
        Optional<Product> productOpt = productService.getById(id);
        if(productOpt.isPresent()) {
            Product product = productOpt.get();
            model.addAttribute("product", product);
            return "product";
        }
        return "redirect:/";
    }
}
