package ru.geekbrains.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import ru.geekbrains.persist.Product;
import ru.geekbrains.interfaces.ProductInter;
import ru.geekbrains.persist.ProductParams;




@Controller
@RequestMapping("/product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductInter productInter;

    @Autowired
    public ProductController(ProductInter productInter) {
        this.productInter = productInter;
    }

    @GetMapping
    public String listPage(Model model,
                           ProductParams productParams) {
        logger.info("Product list page requested");

        model.addAttribute("products", productInter.findWithFilter(productParams));

        return "product";
    }

    @GetMapping("/new")
    public String newProductForm(Model model) {
        logger.info("New product page requested");

        model.addAttribute("product", new Product());
        return "product_form";
    }

    @GetMapping("/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productInter.findById(id));
        return "product_form";
    }

    @PostMapping("/add")
    public String update(Product product) {
        if(product.getId()==null){
            logger.info("Add product"+product);
            productInter.save(product);
        } else {
            logger.info("Update product"+product);
            productInter.save(product);
        }
        return "redirect:/product";
    }


    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") Long id) {
        logger.info("Delete product id "+id);
        productInter.deleteById(id);
        return "redirect:/product";
    }




}