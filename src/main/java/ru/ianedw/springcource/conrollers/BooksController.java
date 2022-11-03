package ru.ianedw.springcource.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ianedw.springcource.dao.BooksDAO;
import ru.ianedw.springcource.models.Book;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final BooksDAO dao;

    @Autowired
    public BooksController(BooksDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", dao.index());
        return "book/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", dao.show(id));
        return "book/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute Book book) {
        return "book/new";
    }

    @PostMapping
    public String create(@ModelAttribute @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/new";
        }
        dao.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", dao.show(id));
        return "book/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "book/edit";
        }
        dao.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        dao.delete(id);
        return "redirect:/books";
    }
}
