package oxymat.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import oxymat.demo.*;

@Controller
public class UController {


    @Autowired
    private UserRepository users = new UserRepository();

    private User activeUser = new User(0, "null", "null");


    @GetMapping("/")
    public String index(Model model, User users) {
        users = activeUser;
        model.addAttribute("users", users);
        model.addAttribute("us", model);

        return "index";
    }

    @ModelAttribute("login")
    public Login addEmptyLogin(){

        return new Login();
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, Model model){

        activeUser = new User(0,login.getUsername(),login.getPassword());
        System.out.println(login.getUsername()+" : "+login.getPassword());
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model){

        model.addAttribute("login", new Login());


        return "index";
    }


    @GetMapping("/create")
    public String create(Model model){

        model.addAttribute("user", new User());

        return "create";
    }


    @PostMapping("/create")
    public String create(@ModelAttribute User user){

        users.create(user);

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute User user){

        users.delete(user.getId());
        System.out.println("deleted : "+user.getId());

        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(Model model){

        model.addAttribute("user", new User());

        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User update){


        users.update(update);
        System.out.println(update.getUsername()+" "+update.getNewpass()+" "+update.getPassword1()+" "+update.getPassword2()+" ");

        return "redirect:/";
    }


}