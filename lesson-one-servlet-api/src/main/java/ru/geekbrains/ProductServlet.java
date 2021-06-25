package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        List<Product> productList = productRepository.findAll();

        if (req.getPathInfo() == null) {

            writer.println("<table>");
            writer.println("<h3>Таблица продуктов<h3>");
            writer.println("<tr>");
            writer.println("<th>#</th>");
            writer.println("<th>Наименование товара</th>");
            writer.println("<th>Цена</th>");
            writer.println("</tr>");

            for (Product product : productList) {
                writer.println("<tr>");
                writer.println("<td>" + product.getId() + "</td>");
                writer.println("<td><a href=" +
                        req.getContextPath() +
                        req.getServletPath() + "/" +
                        product.getId() + ">" + product.getName() + "</a></td>>");
                writer.println("<td>" + product.getCost() + "</td>");
                writer.println("</tr>");
            }
        } else {
            String pathInfo = req.getPathInfo().replace("/","");
            int idParse = Integer.parseInt(pathInfo);
            Product product = productRepository.findById(idParse);
            writer.println("<h1>" + product.getName() +" "+ product.getCost() + "</h1>");
            writer.println("<br>");
            writer.println("<h3> Описание товара </h3>");
            writer.println("<div>" + product.getDisc() + "</div>");
            writer.println("<h3> Стоимость</h3>");
            writer.println("<div>" + product.getCost()+ "</div>");
        }


    }
}
