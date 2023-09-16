package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addBook(@RequestParam String title, @RequestParam Integer rating,
                          @RequestParam String description, @RequestParam String publisherName) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherName);
        publisherDao.save(publisher);

        Book book = new Book();
        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);
        book.setPublisher(publisher);

        Author author1 = authorDao.getById(1L);
        Author author2 = authorDao.getById(2L);
        if (author1 != null) {
            book.getAuthors().add(author1);
        }
        if (author2 != null) {
            book.getAuthors().add(author2);
        }

        bookDao.save(book);
        return book.toString();
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestParam Long id, @RequestParam String title, @RequestParam Integer rating, @RequestParam String description) {
        Book book = bookDao.getById(id);
        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/get")
    @ResponseBody
    public String getById(@RequestParam Long id) {
        return bookDao.getById(id).toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id) {
        Book book = bookDao.getById(id);
        bookDao.delete(book);
        return "redirect:/book/list";
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public String getAll() {
        List<Book> books = bookDao.getAll();
        return books.toString();
    }

    @RequestMapping("getAllByRating")
    @ResponseBody
    public String getAllByRating(@RequestParam int rating) {
        List<Book> books = bookDao.getAllByRating(rating);
        return books.toString();
    }

    @RequestMapping("getAllWithPublisher")
    @ResponseBody
    public String getAllByWithPublisher() {
        List<Book> books = bookDao.getAllWithPublisher();
        return books.toString();
    }

    @RequestMapping("getAllByPublisher")
    @ResponseBody
    public String getAllByPublisher(@RequestParam Long publisherId) {
        Publisher publisher = publisherDao.getById(publisherId);
        List<Book> books = bookDao.getAllByPublisher(publisher);
        return books.toString();
    }

    @RequestMapping("getAllByAuthor")
    @ResponseBody
    public String getAllByAuthor(@RequestParam Long authorId) {
        Author author = authorDao.getById(authorId);
        List<Book> books = bookDao.getAllByAuthor(author);
        return books.toString();
    }
}
