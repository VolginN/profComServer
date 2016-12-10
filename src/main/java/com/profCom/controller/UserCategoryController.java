package com.profCom.controller;

import com.profCom.entity.Category;
import com.profCom.entity.UserCategory;
import com.profCom.repository.CategoryRepository;
import com.profCom.repository.UserCategoryRepository;
import com.profCom.repository.UserRepository;
import com.profCom.service.Category.CategoryService;
import com.profCom.service.User.UserService;
import com.profCom.service.UserCategory.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VolgiNN on 10.12.2016.
 */
@RestController
public class UserCategoryController {
    @Autowired
    private UserCategoryService service;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/UserCategory/{Uid}", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getCategoriesByUid(@PathVariable("Uid") Long Uid){
        List<UserCategory> listUC=service.findByUser(userService.getByID(new Long(Uid)));
        List<Category> listC=new ArrayList<Category>();
        for(UserCategory UC:listUC)
        {
            listC.add(UC.category);
        }
        return listC;
    }

    @RequestMapping(value = "/UserCategory/{Uid}/{Cid}", method = RequestMethod.GET)
    @ResponseBody
    public boolean searchByUidAndCid(@PathVariable("Uid") Long Uid,@PathVariable("Cid") Integer Cid){
        List<UserCategory> userCategory=service.findByUserAndCategory(userService.getByID(new Long(Uid)),categoryService.getByID(Cid));
        if (userCategory.isEmpty())
        {
            return false;
        }
        return true;
    }
}
