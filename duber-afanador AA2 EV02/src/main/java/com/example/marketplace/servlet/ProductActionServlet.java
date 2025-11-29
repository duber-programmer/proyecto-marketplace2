package com.example.marketplace.servlet;

import com.example.marketplace.dao.ProductDAO;
import com.example.marketplace.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ProductActionServlet", urlPatterns = { "/product-action" })
public class ProductActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String priceStr = req.getParameter("price");

        double price = 0;
        if (priceStr != null && !priceStr.isEmpty()) {
            try {
                price = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                price = 0;
            }
        }

        com.example.marketplace.model.Product p = new com.example.marketplace.model.Product();
        if (idStr != null && !idStr.isEmpty()) {
            try {
                p.setId(Integer.parseInt(idStr));
            } catch (NumberFormatException e) {
            }
        }
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);

        ProductDAO.save(p);
        resp.sendRedirect(req.getContextPath() + "/products");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delete = req.getParameter("delete");
        String idStr = req.getParameter("id");
        if ("1".equals(delete) && idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                ProductDAO.deleteById(id);
            } catch (NumberFormatException e) {
            }
        }
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}
