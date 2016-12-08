package com.profCom.controller;

import com.profCom.entity.Password;
import com.profCom.service.Password.PasswordService;
import com.profCom.sysLogic.LoginPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by VolgiNN on 08.12.2016.
 */

@RestController
public class PasswordController {
    @Autowired
    private PasswordService service;

    @RequestMapping(value = "/Password/{login}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public long login(@PathVariable("login") String login,@PathVariable("password") String password) {
        Password pass = service.getByID(login);
        if (pass == null)
            return -2;
        if (password.equals(pass.password))
            return pass.user.id;
        return -1;
    }


    @RequestMapping(value = "/Password", method = RequestMethod.POST)
    @ResponseBody
    public Password savePassword(@RequestBody Password Password) {
        return service.save(Password);
    }

    @RequestMapping(value = "/Password/{login}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String login) {
        service.remove(login);
    }
}
