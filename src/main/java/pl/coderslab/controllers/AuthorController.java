package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addAuthor(@RequestParam String firstName, @RequestParam String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.save(author);
        return author.toString();
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName) {
        Author author = authorDao.getById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);
        return author.toString();
    }

    @RequestMapping("/get")
    @ResponseBody
    public String getById(@RequestParam Long id) {
        Author author = authorDao.getById(id);
        return author.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id) {
        Author author = authorDao.getById(id);
        authorDao.delete(author);
        return "redirect:/author/list";
    }

    @RequestMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("authors", authorDao.getAll());
        return "author/list";
    }

    @GetMapping("/form")
    public String formAdd(@RequestParam(required = false) Long id, Model model) {
        Author author = new Author();
        if (id != null && authorDao.getById(id) != null) {
            author = authorDao.getById(id);
        }
        model.addAttribute("author", author);
        return "author/addForm";
    }

    @PostMapping("/form")
    public String addAuthor(Author author) {
        authorDao.update(author);
        return "redirect:/author/list";
    }

    @RequestMapping("/confirmDelete")
    public String confirmDelete(@RequestParam Long id, Model model) {
        model.addAttribute("author", authorDao.getById(id));
        return "author/confirmDelete";
    }
}
