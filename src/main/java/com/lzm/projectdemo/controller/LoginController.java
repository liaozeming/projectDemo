package com.lzm.projectdemo.controller;

import com.lzm.projectdemo.config.Result;
import com.lzm.projectdemo.entity.Login;
import com.lzm.projectdemo.entity.PageEntity;
import com.lzm.projectdemo.entity.vo.UserLogin;
import com.lzm.projectdemo.repository.LoginRepository;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 登录
 * @author: lzm
 * @create: 2023-04-27 16:45
 **/
@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @GetMapping("/{loginId}")
    public Login getLogin(@PathVariable int loginId) {
        return loginRepository.findById(loginId).orElse(null);
    }

    @PostMapping("/page")
    public Page<Login> getLoginList(@RequestBody PageEntity pageEntity) {
        return loginRepository.findAll(pageEntity.toPageable());
    }

    @GetMapping("/test/{clientId}")
    public Result<List<UserLogin>> testLoginByClientId(@PathVariable int clientId) {
        return Result.ok(loginRepository.testLoginByClientId(clientId));
    }
}
