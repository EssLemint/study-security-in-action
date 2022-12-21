package com.secu.secu.product;

import com.secu.secu.table.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Productrepository extends JpaRepository<Product, Long> {

}
