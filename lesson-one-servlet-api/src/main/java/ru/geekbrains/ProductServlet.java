package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        List<Product> productList = productRepository.findAll();
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\" width=\"600\">\n");
        sb.append("<tr><td><b>ID</b></td><td><b>Product</b></td></tr>\n");
        for (Product product : productList) {
            sb.append("<tr>\n");
            sb.append("<td>"+product.getId()+"</td><td>"+product.getName()+"</td>\n");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        resp.getWriter().println(sb);

    }
}
