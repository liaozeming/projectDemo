package com.lzm.projectdemo.repository;

import com.lzm.projectdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @description:
 * @author: lzm
 * @create: 2023-04-27 21:53
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByNameAndPassword(String name, String password);
}
