package com.example.marketplace.dao;

import com.example.marketplace.model.Product;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductDAO {
    private static final Map<Integer, Product> products = new LinkedHashMap<>();
    private static final AtomicInteger idGen = new AtomicInteger(1);

    static {
        save(new Product(0,"Camiseta","Camiseta de algodón",29.99));
        save(new Product(0,"Gorra","Gorra snapback",19.5));
    }

    public static List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public static Product findById(int id) {
        return products.get(id);
    }

    public static Product save(Product p) {
        if (p.getId() == 0) {
            int id = idGen.getAndIncrement();
            p.setId(id);
        }
        products.put(p.getId(), p);
        return p;
    }

    public static void deleteById(int id) {
        products.remove(id);
    }
}
