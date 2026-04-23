package com.session6.exam6.controller;

import com.session6.exam6.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1, "Java", "Nguyễn A", 150000));
        books.add(new Book(2, "Python", "Trần B", 350000));
        books.add(new Book(3, "Spring", "Lê C", 200000));
        books.add(new Book(4, "Web Application", "Phạm D", 400000));
    }

    @GetMapping("")
    public String listBooks(Model model) {
        model.addAttribute("list", books);
        return "books/list";
    }

    @GetMapping("/{id}")
    public String detailBook(@PathVariable int id, Model model) {
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("book", book);
        return "books/detail";
    }
}
