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

/**
 * @className:
 * @author: srpihot
 * @description: TODO
 * @date: 2021/6/26 - 22：00
 */
@Controller
public class UserController {

    //注入service
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() { return "login"; }
    @RequestMapping("/index.html")
    public String indexhtml(){ return "login";}
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
            if (user.getGrants().equals("管理员")){
                Page<User> allUser = userService.getUserList(pageNum, pageSize);
                model.addAttribute("allUser", allUser);
                session.setAttribute("user",username);
//                System.out.println(session.getAttribute("user"));
                return "userList";
            }else {
                model.addAttribute("msg","权限级别过低！无法登录！");
                return "login";
            }
        }else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
    @RequestMapping("/userList")
    public String userList(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "8") int pageSize) {
                Page<User> allUser = userService.getUserList(pageNum, pageSize);
                model.addAttribute("allUser", allUser);
                return "userList";
    }
    /** 编辑用户 **/
    @RequestMapping("/editUser")
    public String editUser(@RequestParam String username, @RequestParam String password,
                           @RequestParam String name, @RequestParam String grants,
                           @RequestParam Integer id, Model model) {
        userService.editUser(username, password, name, grants, id);
        List<User> allUser = userService.selectAll();
        model.addAttribute("allUser", allUser);

        return "redirect:/userList";
    }
    /** 删除用户 **/
    @RequestMapping("/deleteUser")
    public String delUser(Integer id, Model model) {
        userService.delUserById(id);
        List<User> allUser = userService.selectAll();
        model.addAttribute("allUser", allUser);
        return "redirect:/userList";
    }
    /** 添加用户 **/
    @RequestMapping("/addUser")
    public String addUser(@RequestParam String username, @RequestParam String password,
                          @RequestParam String name, @RequestParam String grants, Model model) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setGrants(grants);
        userService.saveUser(user);
        List<User> allUser = userService.selectAll();
        model.addAttribute("allUser", allUser);
        return "redirect:/userList";
    }



}

