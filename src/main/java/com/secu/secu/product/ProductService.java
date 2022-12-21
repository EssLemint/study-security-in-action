package com.secu.secu.product;

import com.secu.secu.table.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  @Autowired
  private Productrepository productrepository;

  public List<Product> findAll() {
    return productrepository.findAll();
  }
}
