package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.model.Person;
import pl.coderslab.model.PersonDetails;

@Controller
@RequestMapping("/personDetails")
public class PersonDetailsController {
    private PersonDetailsDao detailsDao;
    private PersonDao personDao;

    public PersonDetailsController(PersonDetailsDao detailsDao, PersonDao personDao) {
        this.detailsDao = detailsDao;
        this.personDao = personDao;
    }

    @RequestMapping(path = "/add")
    @ResponseBody
    public String addPersonDetails(@RequestParam Long personID, @RequestParam String firstName,
                                  @RequestParam String lastName, @RequestParam Integer streetNumber, @RequestParam String street,
                                  @RequestParam String city) {
        Person person = personDao.getById(personID);

        PersonDetails personDetails = new PersonDetails();
        personDetails.setId(person.getId());
        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setStreetNumber(streetNumber);
        personDetails.setStreet(street);
        personDetails.setCity(city);
        personDetails.setPerson(person);
        detailsDao.update(personDetails);
        return personDetails.toString();
    }

    @RequestMapping(path = "/update")
    @ResponseBody
    public String update(@RequestParam Long personID, @RequestParam String firstName,
                                    @RequestParam String lastName, @RequestParam Integer streetNumber, @RequestParam String street,
                                    @RequestParam String city) {
        PersonDetails personDetails = detailsDao.getById(personID);
        personDetails.setId(personID);
        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setStreetNumber(streetNumber);
        personDetails.setStreet(street);
        personDetails.setCity(city);
        detailsDao.update(personDetails);
        return personDetails.toString();
    }


    @RequestMapping(path = "/get")
    public String getById(@RequestParam Long id) {
        return detailsDao.getById(id).toString();
    }

    @RequestMapping(path = "/delete")
    @ResponseBody
    public String delete(@RequestParam Long id) {
        PersonDetails details = detailsDao.getById(id);
        detailsDao.delete(details);
        return "Person details deleted";
    }
}
