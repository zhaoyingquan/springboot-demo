package com.example.service;

import com.example.pojo.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @className:
 * @author: sir
 * @description: TODO
 * @date: 2021/6/26 - 23:05
 */
public interface UserService {

    User checkUser(String username, String password);

    List<User> selectAll();

    Page<User> getUserList(int pageNum,int pageSize);

    User saveUser(User user);

    void delUserById(Integer id);

    void editUser(String username,String password,String name,String grants,Integer id);

}
