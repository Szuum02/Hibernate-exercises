package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherDao publisherDao;
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addPublisher(@RequestParam String name) {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisherDao.save(publisher);
        return publisher.toString();
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestParam Long id, @RequestParam String name) {
        Publisher publisher = publisherDao.getById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/get")
    @ResponseBody
    public String getById(@RequestParam Long id) {
        Publisher publisher = publisherDao.getById(id);
        return publisher.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id) {
        Publisher publisher = publisherDao.getById(id);
        publisherDao.delete(publisher);
        return "redirect:/publisher/list";
    }

    @RequestMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("publishers", publisherDao.getAll());
        return "publisher/list";
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Long id,  Model model) {
        Publisher publisher = new Publisher();
        if (id != null && publisherDao.getById(id) != null) {
            publisher = publisherDao.getById(id);
        }
        model.addAttribute("publisher", publisher);
        return "publisher/addForm";
    }

    @PostMapping("/form")
    public String updatePublisher(Publisher publisher) {
        publisherDao.update(publisher);
        return "redirect:/publisher/list";
    }

    @RequestMapping("/confirmDelete")
    public String confirmDelete(@RequestParam Long id, Model model) {
        model.addAttribute("publisher", publisherDao.getById(id));
        return "publisher/confirmDelete";
    }
}
