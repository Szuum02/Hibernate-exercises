package pl.coderslab.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Publisher;

import java.util.Collection;


public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    private PublisherDao publisherDao;

    @Override
    public Publisher convert(String source) {
        return publisherDao.getById(Long.valueOf(source));
    }
}
