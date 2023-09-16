package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.model.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
    private PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addPerson(@RequestParam String login, @RequestParam String password,
                            @RequestParam String email) {
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        personDao.save(person);
        return person.toString();
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestParam Long id, @RequestParam String login, @RequestParam String password,
                            @RequestParam String email) {
        Person person = personDao.getById(id);
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        personDao.update(person);
        return person.toString();
    }

    @RequestMapping("/get")
    @ResponseBody
    public String getById(@RequestParam Long id) {
        return personDao.getById(id).toString();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam Long id) {
        Person person = personDao.getById(id);
        personDao.delete(person);
        return "Person deleted";
    }

    @GetMapping("/form")
    public String displayForm(Model model) {
        Person person = new Person();
        person.setLogin("Szuum02");
        model.addAttribute("person", person);
        return "person/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String displayForm(Person person) {
        personDao.update(person);
        return person.toString();
    }

//    @PostMapping("/form")
//    @ResponseBody
//    public String processForm(@RequestParam String login, @RequestParam String password, @RequestParam String email) {
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//        personDao.save(person);
//        return person.toString();
//    }
}
