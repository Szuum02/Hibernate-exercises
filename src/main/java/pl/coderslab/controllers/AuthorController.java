package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public String delete(@RequestParam Long id) {
        Author author = authorDao.getById(id);
        authorDao.delete(author);
        return "Author deleted";
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public String getAll() {
        return authorDao.getAll().toString();
    }
}
