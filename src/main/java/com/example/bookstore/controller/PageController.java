package com.example.bookstore.controller;

import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class PageController {

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/addBook")
    public String addBookPage(@AuthenticationPrincipal UserDetails currentUser, Model model) {
        if (currentUser != null) {
            logger.info("User {} is authenticated, navigating to add_book page", currentUser.getUsername());
            model.addAttribute("username", currentUser.getUsername());
            return "add_book";
        } else {
            logger.warn("User is not authenticated, redirecting to login page");
            return "redirect:/login";
        }
    }

    @GetMapping("/books")
    public String bookListPage(@AuthenticationPrincipal UserDetails currentUser, Model model) {
        if (currentUser != null) {
            logger.info("User {} is authenticated, navigating to book_list page", currentUser.getUsername());
            model.addAttribute("username", currentUser.getUsername());
            model.addAttribute("books", bookService.getAllBooks());
            return "book_list";
        } else {
            logger.warn("User is not authenticated, redirecting to login page");
            return "redirect:/login";
        }
    }
}
