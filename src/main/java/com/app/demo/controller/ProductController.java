package com.app.demo.controller;

import com.app.demo.model.Product;
import com.app.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/saveproduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        System.out.println(" received input Request Data : " + product);
        Product productResponse = this.productService.createProduct(product);
        return ResponseEntity.ok().body(productResponse);
    }

    @GetMapping("/getallproducts")
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        System.out.println(" received input product id : " + id);
        return ResponseEntity.ok().body(productService.getProductById(id));
    }
    @PutMapping("/updateproducts/{id}")
    public ResponseEntity < Product > updateProduct(@PathVariable long id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }
    @DeleteMapping("/deleteproducts/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        this.productService.deleteProduct(id);
        return HttpStatus.OK;
    }
}
