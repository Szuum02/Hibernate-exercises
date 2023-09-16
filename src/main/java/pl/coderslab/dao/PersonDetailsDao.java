package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(PersonDetails details) {
        entityManager.persist(details);
    }

    public void update(PersonDetails details) {
        entityManager.merge(details);
    }

    public PersonDetails getById(Long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void delete(PersonDetails details) {
        entityManager.remove(entityManager.contains(details) ? details : entityManager.merge(details));
    }
}