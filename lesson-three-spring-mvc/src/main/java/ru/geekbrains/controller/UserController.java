package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public String  listPage(Model model){
        logger.info("User list page requested");

        model.addAttribute("users",repository.findAll());
        return "users";
    }
    @GetMapping("/new")
    public String newUserForm(Model model){
        logger.info("New user list page requested");
        model.addAttribute("user",new User());
        return "user_form";
    }
    @PostMapping
    public String update(User user){
        logger.info("Save user");
        repository.insert(user);
        return "redirect:/user";
    }
}
