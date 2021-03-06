package com.github.prgms.socialserver.web;

import com.github.prgms.socialserver.domain.user.User;
import com.github.prgms.socialserver.service.UserService;
import com.github.prgms.socialserver.web.dto.PostsUserRequestDto;
import com.github.prgms.socialserver.web.dto.PostsUserResponseDto;
import com.github.prgms.socialserver.web.dto.UserListResponseDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserListResponseDto> getAllUserList(){
        return userService.allUserList();
    }

    @GetMapping("/users/{email}")
    public UserListResponseDto getUserList(@PathVariable String email){
        return userService.userInfoList(email);
    }

    @PostMapping("/users/join")
    public PostsUserResponseDto insertUser(@RequestBody PostsUserRequestDto postsUserRequestDto){
        return userService.registerUser(postsUserRequestDto);
    }
}
