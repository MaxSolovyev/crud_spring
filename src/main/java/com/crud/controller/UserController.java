package com.crud.controller;

import com.crud.service.abstraction.UserService;
import com.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("userAuth")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String view() {
        return "/index";
    }

    @GetMapping("/admin")
    public String showUsers(Model model) {
        model.addAttribute("users",userService.getAll());

        return "user";
    }

    @GetMapping("/confidential")
    public String Conf(Model model) {
        return "/confidential";
    }


    @GetMapping("/admin/register")
    public String getNewUserForm(Model model) {
        return "/new";
    }

    @PostMapping("admin/register")
    public String AddUser(@ModelAttribute User user) {
        userService.save(user);

        return "redirect:/admin";
    }

    @GetMapping("/admin/edit")
    public String getEditUser(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("user", userService.get(id));

        return "/edit";
    }

    @PostMapping("/admin/edit")
    public String EditUser(@ModelAttribute User user) {
        userService.update(user);

        return "redirect:/admin";
    }

    @GetMapping("/admin/delete")
    public String DeleteUser(@RequestParam(value = "id") long id) {
        userService.delete(userService.get(id));

        return "redirect:/admin";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "/login";
    }

    @GetMapping("/main")
    public String getMainPage(Model model) {
        return "/main";
    }

    @ModelAttribute("user")
    public User createUser() {
        return new User();
    }

//    @PostMapping("/login")
//    public String Login(@RequestParam("login") String login,
//                               @RequestParam("password") String password,
//                               Model model) {
//
//        User user = userService.getByLogin(login);
//        String destination = "redirect:/login";
//        if (user!=null) {
//            if (password.equals(user.getPassword())) {
//                if ("admin".equals(user.getRole())) {
//                    destination = "redirect:/admin";
//                } else {
//                    destination = "redirect:/main";
//                }
//            } else {
//                user = null;
//            }
//        }
//        model.addAttribute("userAuth",user);
//
//        return destination;
//    }

    @GetMapping("/error")
    public String errorPage(Model model) {
        return "/error";
    }

    @GetMapping("/accessDenied")
    public String accessDeniedPage(Model model) {
        return "/accessDenied";
    }

//    @GetMapping("/default")
//    public String redirectDefault(HttpServletRequest request) {
//        if (request.isUserInRole("admin")) {
//            return "redirect: /admin";
//        }
//        return "redirect: /main";
//    }

}