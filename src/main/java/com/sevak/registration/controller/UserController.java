package com.sevak.registration.controller;

import com.sevak.registration.model.User;
import com.sevak.registration.service.FileService;
import com.sevak.registration.util.Md5;
import com.sevak.registration.util.Validation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class UserController {


    public static final String path = "data"+ File.separator+"data.txt";

    @PostMapping("/login")
    public String postLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model){
        List<User> users = FileService.read(path);
        for (User user : users) {
            if(user.getEmail().equals(email)&&user.getPassword().equals(Md5.md5Custom(password))) {
                model.addAttribute("user", user);
                return "success";
            }
        }
        model.addAttribute("error", true);

        return "login";
    }

    @GetMapping("/login")
    public String getLogin(HttpServletRequest request, Model model){
        if(request.getParameterMap().containsKey("error")){
            model.addAttribute("error", true);
        }
        return "login";
    }

    @GetMapping("/registry")
    public String getRegistry(){

        return "registry";
    }

    @PostMapping("/registry")
    public String postRegistry(@RequestParam("name") String name, @RequestParam("surname") String surname,
                               @RequestParam("email") String email, @RequestParam("age") int age,
                               @RequestParam("password") String password, Model model){
        String result = Validation.valid(name, surname, email, age, password);
        if(result.equals("ok")){
            List<User> users = FileService.read(path);
            for (User user : users) {
                if(user.getName().equals(name)&&user.getSurname().equals(surname)||user.getEmail().equals(email)) {
                    model.addAttribute("isExist", true);
                    return "registry";
                }
            }
            FileService.write(path, new User(name, surname,email,age, Md5.md5Custom(password)));
        }else{
            model.addAttribute("isIncorrect", true);
            model.addAttribute("result", result);
            return "registry";
        }

          return "ok";
    }
}
