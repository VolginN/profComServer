package com.profCom.service.News;

import com.profCom.entity.News;
import com.profCom.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by VolgiNN on 08.12.2016.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository repository;

    public List<News> getAll() {
        return repository.findAll();
    }

    public News getByID(long id) {
        return repository.findOne(id);
    }

    public News save(News news) {
        return repository.saveAndFlush(news);
    }

    public void remove(long id) {
        repository.delete(id);
    }
}
