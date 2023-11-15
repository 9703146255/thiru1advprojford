package in.thiru.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.thiru.dao.ProductDao;
import in.thiru.dto.ProductDTO;

@WebServlet("/ProductServletGetAllData")
public class ProductServletGetAllData extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao dao = new ProductDao();
        try {
            List<ProductDTO> productData = dao.getProductData(null);

            request.setAttribute("productList", productData);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("products.jsp").forward(request, response);
    }
}
