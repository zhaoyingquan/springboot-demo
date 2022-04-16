package com.example.dao;

import com.example.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 根据username、password查询用户，实现用户的登录
     * @param username
     * @param password
     * @return
     */
    @Query(value = "select u from User u where u.username = ?1 and u.password = ?2")
    User vaildUser(String username, String password);

    /**
     * 查询所有的数据
     * @return
     */
    @Query(value = "select u from User u ")
    List<User> findAll();


    /**
     * 根据id删除用户
     */
    @Transactional
    @Modifying
    @Query(value = " delete from User u where u.id = ?1 ")
    void delUserById(Integer id);

    /**
     * 根据id修改用户
     * @param username
     * @param password
     * @param grants
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value = "update User u set u.username = ?1,u.password = ?2, u.grants = ?3 where u.id = ?4")
    void updateUser(String username,String password,String grants,Integer id);

}
