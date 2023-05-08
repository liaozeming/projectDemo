package com.lzm.projectdemo.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.lzm.projectdemo.config.Result;
import com.lzm.projectdemo.entity.User;
import com.lzm.projectdemo.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @description:
 * @author: lzm
 * @create: 2023-04-27 21:48
 **/
@RestController
@RequestMapping("/saLogin")
public class SaLoginController {
    private final UserRepository userRepository;

    public SaLoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/doLogin")
    public Result<String> doLogin(String name, String pwd) {
        Optional<User> userOptional = userRepository.findUserByNameAndPassword(name, pwd);
        if (userOptional.isPresent()) {
            StpUtil.login(userOptional.get().getId());
            return Result.ok("登录成功");
        }
        return Result.error("登录失败");
    }

    // 查询登录状态  ---- http://localhost:8081/acc/isLogin
    @RequestMapping("/isLogin")
    public Result<String> isLogin() {
        return Result.ok("是否登录：" + StpUtil.isLogin());
    }

    // 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
    @RequestMapping("/tokenInfo")
    public Result<SaTokenInfo> tokenInfo() {
        return Result.ok(StpUtil.getTokenInfo());
    }

    @RequestMapping("/logout")
    public Result<String> logout() {
        StpUtil.logout();
        return Result.ok();
    }

}
