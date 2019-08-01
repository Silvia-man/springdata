package com.damo.dao;

import com.damo.modal.Product;

import java.util.List;

public interface IProduct {
    Product getProductById(Integer id);
    List<Product> getProducts();
    boolean createProduct(Product product);
    boolean deleteProduct(Product product);
}

