package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {
  @GetMapping("/products")
  public ArrayList<Product> products() throws IOException{
    return JSONManager.readProducts();
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<Product> productsById(@PathVariable int id) throws IOException{
    ArrayList<Product> products = JSONManager.readProducts();

    for (Product product : products) {
      if(product.getId() == id){
        return ResponseEntity.ok(product);
      }
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping("/products")
  public Product createProduct(@RequestBody Product newProduct) throws IOException{
    ArrayList<Product> products = JSONManager.readProducts();
    
    newProduct.setId(products.size() + 1);
    
    products.add(newProduct);

    JSONManager.saveProducts(products);
    
    return newProduct;
  }
}
