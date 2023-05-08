package com.lzm.projectdemo.repository;

import com.lzm.projectdemo.entity.Login;
import com.lzm.projectdemo.entity.vo.UserLogin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    Page<Login> findAll(Pageable pageable);

    @Query(value = "SELECT\n" +
            "\t `user`.`name`, login.date  \n" +
            "FROM\n" +
            "\t`user`\n" +
            "\tLEFT JOIN login ON `user`.id = login.user_id \n" +
            "WHERE\n" +
            "\tclient_id = (?1)", nativeQuery = true)
    List<UserLogin> testLoginByClientId(int client_Id);
}
