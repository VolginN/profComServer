package com.profCom.service.UserCategory;

import com.profCom.entity.Category;
import com.profCom.entity.User;
import com.profCom.entity.UserCategory;
import com.profCom.repository.UserCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by VolgiNN on 08.12.2016.
 */
@Service
public class UserCategoryServiceImpl implements UserCategoryService {

    @Autowired
    private UserCategoryRepository repository;

    public List<UserCategory> getAll() {
        return repository.findAll();
    }

    public UserCategory getByID(long id) {
        return repository.findOne(id);
    }

    public UserCategory save(UserCategory userCategory) {
        return repository.saveAndFlush(userCategory);
    }

    public void remove(long id) {
        repository.delete(id);
    }

    public List<UserCategory> findByUser(User u){
        return repository.findByUser(u);
    }

    public List<UserCategory> findByUserAndCategory(User user, Category category){
        return repository.findByUserAndCategory(user,category);
    }
}
