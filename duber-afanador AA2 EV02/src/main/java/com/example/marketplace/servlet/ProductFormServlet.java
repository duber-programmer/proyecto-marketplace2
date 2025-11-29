package com.example.marketplace.servlet;

import com.example.marketplace.dao.ProductDAO;
import com.example.marketplace.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name="ProductFormServlet", urlPatterns={"/product-form"})
public class ProductFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Product p = ProductDAO.findById(id);
                req.setAttribute("product", p);
            } catch (NumberFormatException e) { /* ignore */ }
        }
        req.getRequestDispatcher("/product-form.jsp").forward(req, resp);
    }
}
