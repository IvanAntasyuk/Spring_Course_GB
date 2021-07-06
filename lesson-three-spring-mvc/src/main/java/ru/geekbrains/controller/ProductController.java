package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String listPage(Model model) {
        logger.info("Product list page requested");

        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/new")
    public String newProductForm(Model model) {
        logger.info("New product page requested");

        model.addAttribute("product", new Product());
        return "product_form";
    }

    @GetMapping("/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        logger.info("Edit product");

        model.addAttribute("product", productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("User not found")));
        return "product_form";
    }

    @PostMapping
    public String update(Product product) {
        logger.info("Saving product");
        if (product.getId() != null) {
            productRepository.update(product);
        } else productRepository.insert(product);
        return "redirect:/product";
    }

    @ExceptionHandler()
    public ModelAndView notFoundExceptionHandler(NotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("not_found");
        modelAndView.addObject("message",exception.getMessage());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
}