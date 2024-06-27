package com.chainsys.demo2.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.demo2.DAO.UserDAOImpl;
import com.chainsys.demo2.model.User;

@Controller
public class MyController {
    @Autowired
    UserDAOImpl userDAOImpl;

    @RequestMapping("/home")
    public String home() {
        return "home.jsp";
    }

    @GetMapping("click")
    public String saveStudent(@RequestParam("name") String userName, @RequestParam("age") Integer age,
            @RequestParam("mobileNo") String mobileNo, @RequestParam("gender") String gender,
            @RequestParam("address") String address, Model model) throws ClassNotFoundException, SQLException {
        User user = new User();
        user.setUserName(userName);
        user.setAge(age);
        user.setMobileNo(mobileNo);
        user.setGender(gender);
        user.setAddress(address);
        userDAOImpl.insertUser(user);

        List<User> getDetails = userDAOImpl.listUsers();
        model.addAttribute("users", getDetails);

        return "viewUsers.jsp";
    }

    @PostMapping("deleteUser")
    public String deleteUser(@RequestParam("id") int id, Model model) throws SQLException {
        userDAOImpl.deleteUser(id);
        List<User> getDetails = userDAOImpl.listUsers();
        model.addAttribute("users", getDetails);
        return "viewUsers.jsp";
    }

    @GetMapping("showUpdateForm")
    public String showUpdateForm(@RequestParam("id") int id, Model model) throws SQLException {
        User user = userDAOImpl.findUserById(id);
        model.addAttribute("user", user);
        return "updateUsers.jsp";
    }

    @PostMapping("updateUser")
    public String updateUser(@RequestParam("id") int id, @RequestParam("name") String userName, 
            @RequestParam("age") Integer age, @RequestParam("mobileNo") String mobileNo, 
            @RequestParam("gender") String gender, @RequestParam("address") String address, 
            Model model) throws SQLException {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setAge(age);
        user.setMobileNo(mobileNo);
        user.setGender(gender);
        user.setAddress(address);
        userDAOImpl.updateUser(user);

        List<User> getDetails = userDAOImpl.listUsers();
        model.addAttribute("users", getDetails);
        return "viewUsers.jsp";
    }

    @GetMapping("searchUser")
    public String searchUser(@RequestParam("name") String name, Model model) throws SQLException {
        List<User> users = userDAOImpl.findUsersByName(name);
        model.addAttribute("users", users);
        return "viewUsers.jsp";
    }
}
