package com.damo;

import com.damo.config.Config;
import com.damo.dao.IProduct;
import com.damo.modal.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(Config.class);
        IProduct dao = ioc.getBean(IProduct.class);

        print(dao);

        System.out.println("Creating new product...");
        Product product = new Product(1000.0, "TNT");
        dao.createProduct(product);
        print(dao);


        System.out.println("Deleting");
        Product product1 = dao.getProductById(4);
        dao.deleteProduct(product1);

        print(dao);

    }

    private static void print(IProduct dao) {
        System.out.println("===============================================");
        System.out.println("list of products");
        List<Product> products = dao.getProducts();
        for(Product product : products) {
            System.out.println(product);
        }
        System.out.println("");
    }
}
