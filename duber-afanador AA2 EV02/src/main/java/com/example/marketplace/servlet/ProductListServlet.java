package com.example.marketplace.servlet;

import com.example.marketplace.dao.ProductDAO;
import com.example.marketplace.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ProductListServlet", urlPatterns={"/products"})
public class ProductListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductDAO.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/product-list.jsp").forward(req, resp);
    }
}
