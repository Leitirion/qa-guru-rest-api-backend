package guru.qa.restbackend.controller;

import guru.qa.restbackend.domain.UserInfo;
import guru.qa.restbackend.domain.UserLoginInfo;
import guru.qa.restbackend.exception.InvalidUsernameException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BankController {

    @PostMapping("user/login")
    public UserInfo doLogin(@RequestBody UserLoginInfo userLoginInfo) {
        if (userLoginInfo.getUserName().equals("TestUser")) {
            return UserInfo.builder()
                    .loginDate(new Date())
                    .userName(userLoginInfo.getUserName())
                    .build();
        } else {
            throw new InvalidUsernameException();
        }
    }
}
