package com.example.intern_demo.controller;

import com.example.intern_demo.model.User;
import com.example.intern_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Home page - সব User দেখাবে
    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";  // index.html
    }

    // নতুন User যোগ করার ফর্ম দেখাবে
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "create";  // create.html
    }

    // নতুন User Save করবে
    @PostMapping
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";  // Index page এ redirect
    }

    // User Edit ফর্ম দেখাবে
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id).orElseThrow();
        model.addAttribute("user", user);
        return "edit";  // edit.html
    }

    // User Update করবে
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    // User Delete করবে
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}