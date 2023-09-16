package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Author author) {
        entityManager.persist(author);
    }

    public Author getById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }

    public List<Author> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }
}
