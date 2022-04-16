package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    //注入service
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "login";
    }

    @RequestMapping("/index.html")
    public String indexhtml() {
        return "login";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam String username, @RequestParam String password,
                          @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "8") int pageSize, Model model, HttpSession session) {

        User user = userService.checkUser(username, password);
        if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
            Page<User> allUser = userService.getUserList(pageNum, pageSize);
            model.addAttribute("allUser", allUser);
            model.addAttribute("display", user.getGrants().equals("管理员") ? true : false);
            session.setAttribute("user", user);
            session.setAttribute("username", user.getUsername());
            return "userList";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping("/userList")
    public String userList(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "8") int pageSize, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Page<User> allUser = userService.getUserList(pageNum, pageSize);
        model.addAttribute("allUser", allUser);
        model.addAttribute("display", user.getGrants().equals("管理员") ? true : false);
        return "userList";
    }

    /**
     * 编辑用户
     **/
    @RequestMapping("/editUser")
    public String editUser(@RequestParam String username, @RequestParam String password,
                           @RequestParam String grants,
                           @RequestParam Integer id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (!"管理员".equals(user.getGrants())) {
            model.addAttribute("msg", "无权操作！");
            return "login";
        }
        userService.editUser(username, password, grants, id);
        List<User> allUser = userService.selectAll();
        model.addAttribute("allUser", allUser);

        return "redirect:/userList";
    }

    /**
     * 删除用户
     **/
    @RequestMapping("/deleteUser")
    public String delUser(Integer id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (!"管理员".equals(user.getGrants())||user.getId()==id.intValue()) {
            model.addAttribute("msg", "无权操作！");
            return "login";
        }
        userService.delUserById(id);
        List<User> allUser = userService.selectAll();
        model.addAttribute("allUser", allUser);
        return "redirect:/userList";
    }

    /**
     * 添加用户
     **/
    @RequestMapping("/addUser")
    public String addUser(@RequestParam String username, @RequestParam String password,
                          @RequestParam String grants, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (!"管理员".equals(user.getGrants())) {
            model.addAttribute("msg", "无权操作！");
            return "login";
        }
        User user1 = new User();
        user1.setUsername(username);
        user1.setPassword(password);
        user1.setGrants(grants);
        userService.saveUser(user1);
        List<User> allUser = userService.selectAll();
        model.addAttribute("allUser", allUser);
        return "redirect:/userList";
    }


}

