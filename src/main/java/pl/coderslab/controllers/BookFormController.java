package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookFormController {
    private BookDao bookDao;
    private AuthorDao authorDao;
    private PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, AuthorDao authorDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/form")
    public String displayForm(@RequestParam(required = false) Long id, Model model) {
        Book book;
        if (id == null) {
            book = new Book();
        } else {
            book = bookDao.getById(id);
        }
        model.addAttribute("book", book);
        return "book/form";
    }

    @PostMapping("/form")
    public String saveForm(Book book) {
        bookDao.update(book);
        return "redirect:/book/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Book> books = bookDao.getAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    @RequestMapping("/confirmDelete")
    public String confirmDelete(@RequestParam Long id, Model model) {
        Book book = bookDao.getById(id);
        model.addAttribute("book", book);
        return "book/confirmDelete";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return publisherDao.getAll();
    }

    @ModelAttribute("authors")
    public Collection<Author> authors() {
        return authorDao.getAll();
    }
}
