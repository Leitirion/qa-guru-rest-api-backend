package guru.qa.restbackend.controller;

import guru.qa.restbackend.domain.UserLoginInfo;
import guru.qa.restbackend.domain.UserInfo;
import guru.qa.restbackend.exception.InvalidUsernameException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankController {

    private Map<String, UserInfo> users = Map.of(
            "Dima", UserInfo.builder().userName("Dima").build(),
            "Olga", UserInfo.builder().userName("Olga").build(),
            "Ivan", UserInfo.builder().userName("Ivan").build()
    );

    @PostMapping("user/login")
    @ApiOperation("Авторизация")
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

    @GetMapping("user/getAll")
    @ApiOperation("Получение всех пользователей")
    public List<UserInfo> getAllUsersInfo() {
        return users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
