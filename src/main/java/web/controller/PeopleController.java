package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class PeopleController {
    private final UserService userService;

    @Autowired
    public PeopleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showPeople(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "people";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "edit";

    }

    @PatchMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";

    }

    @DeleteMapping("/edit/{id}")
    public String delete(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.removeUser(user);
        return "redirect:/";
    }


}
