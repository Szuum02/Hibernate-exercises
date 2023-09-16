package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public String delete(@RequestParam Long id) {
        Publisher publisher = publisherDao.getById(id);
        publisherDao.delete(publisher);
        return "Publisher deleted";
    }

    @RequestMapping("getAll")
    @ResponseBody
    public String getAll() {
        return publisherDao.getAll().toString();
    }
}
