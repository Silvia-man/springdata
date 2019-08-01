package com.damo.dao;

import com.damo.modal.Product;
import com.damo.modal.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class ProductImpl implements IProduct{

    JdbcTemplate jdbcTemplate;
    private final String SQL_GET_ALL = "select * from product";
    private final String SQL_GET_ONE = "select * from product where id = ?";
    private final String SQL_NEW_ONE = "insert into product(name, price) values(?,?)" ;
    private final String SQL_DEL_ONE = "delete from product where id = ?";


    @Autowired
    public ProductImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Product getProductById(Integer id) {
        return (Product) jdbcTemplate.queryForObject(
                SQL_GET_ONE,
                new Object[] { id },
                new ProductMapper());
    }

    @Override
    public List<Product> getProducts() {
        return jdbcTemplate.query(SQL_GET_ALL, new ProductMapper());
    }

    @Override
    public boolean createProduct(Product product) {
        return jdbcTemplate.update(SQL_NEW_ONE, product.getName(), product.getPrice()) > 0;

    }

    @Override
    public boolean deleteProduct(Product product) {
        return jdbcTemplate.update(SQL_DEL_ONE, product.getId()) > 0;
    }
}
