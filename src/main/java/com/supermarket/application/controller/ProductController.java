package com.supermarket.application.controller;

import com.supermarket.application.models.Product;
import com.supermarket.application.models.User;
import com.supermarket.application.service.ProductService;
import com.supermarket.application.service.UserService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins= {"https://supermarket-00qp.onrender.com"}, maxAge = 4800, allowCredentials = "true" , methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<Product> list() {
        return productService.listAllProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = productService.getProduct(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    //    @RequestMapping(value = "/",produces = "application/json",method = {RequestMethod.POST})
    @PostMapping("")
    public void add(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product existUser = productService.getProduct(id);
            product.setId(id);
            productService.saveProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/delete")
    public void delete(@RequestBody Product product ) {
        productService.deleteProduct(product.getId());
    }
}