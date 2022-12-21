package com.secu.secu.controller;

import com.secu.secu.product.ProductService;
import com.secu.secu.table.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainPageController {

  @Autowired
  private ProductService productService;

  @GetMapping("/product/main")
  public ResponseEntity<?> main(Authentication authentication) {
    List<Product> all = productService.findAll();

    return ResponseEntity.ok(all);
  }
}
