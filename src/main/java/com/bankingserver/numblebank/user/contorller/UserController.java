package com.bankingserver.numblebank.user.contorller;

import com.bankingserver.numblebank.user.auth.CurrentUser;
import com.bankingserver.numblebank.user.auth.JwtProperties;
import com.bankingserver.numblebank.user.dto.SignInRequest;
import com.bankingserver.numblebank.user.dto.SignUpRequest;
import com.bankingserver.numblebank.user.entity.User;
import com.bankingserver.numblebank.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping ("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody SignUpRequest signUpRequest) {
        userService.join(signUpRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> signIn(@RequestBody SignInRequest signInRequest) {

        String token = userService.login(signInRequest);
        return ResponseEntity.ok().header(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX+token).build();
    }
}
