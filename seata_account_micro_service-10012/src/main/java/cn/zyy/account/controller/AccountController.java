package cn.zyy.account.controller;

import cn.zyy.springcloud.basic.Result;
import cn.zyy.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zz
 * @Date: 2025/06/25/4:31
 * @Description: 致敬
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    //扣减账户金钱
    @PostMapping("/reduce")
    public Result reduce(@RequestParam("userId") Long userId, @RequestParam("money") Integer money) {
        accountService.reduce(userId, money);
        return Result.success("200", "扣减账户余额 OK");
    }
}
