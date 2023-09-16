package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book getById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    public List<Book> getAll() {
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    public List<Book> getAllByRating(int rating) {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Book> getAllWithPublisher() {
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.publisher");
        return query.getResultList();
    }

    public List<Book> getAllByPublisher(Publisher publisher) {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher = :publisher");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

    public List<Book> getAllByAuthor(Author author) {
        Query query = entityManager.createQuery("SELECT b FROM Book b where :author MEMBER OF b.authors");
        query.setParameter("author", author);
        return query.getResultList();
    }
}
