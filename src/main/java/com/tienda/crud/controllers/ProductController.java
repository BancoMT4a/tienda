package com.tienda.crud.controllers;

import com.tienda.crud.models.ProductDTO;
import com.tienda.crud.repositories.IProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT})
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductDAO repository;

    @PostMapping("/product")
    public ProductDTO createProduct(@Validated @RequestBody ProductDTO p){
        return repository.insert(p);
    }

    @GetMapping("/")
    public List<ProductDTO> getAllProducts(){
        return repository.findAll();
    }

    @PutMapping("/product/{id}")
    public ProductDTO updateProduct(@PathVariable String id, @Validated @RequestBody ProductDTO p){
        p.set_id(id);
        return repository.save(p);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable String id){
        repository.deleteById(id);
    }

}
