package com.example.service;

import com.example.pojo.User;
import org.springframework.data.domain.Page;

import java.util.List;


public interface UserService {

    User checkUser(String username, String password);

    List<User> selectAll();

    Page<User> getUserList(int pageNum,int pageSize);

    User saveUser(User user);

    void delUserById(Integer id);

    void editUser(String username,String password,String grants,Integer id);

}
