package com.bankingserver.numblebank.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.bankingserver.numblebank.user.dto.SignInRequest;
import com.bankingserver.numblebank.user.dto.SignUpRequest;
import com.bankingserver.numblebank.user.entity.Password;
import com.bankingserver.numblebank.user.entity.User;
import com.bankingserver.numblebank.user.entity.UserId;
import com.bankingserver.numblebank.user.repository.UserRepository;
import com.bankingserver.numblebank.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    private static final UserId userId = UserId.valueOf("jihwan");
    private static final Password password = Password.valueOf("1234");

    @DisplayName("회원가입 처리 - 성공")
    @Test
    void signUp() throws Exception{
        SignUpRequest signUpRequest = new SignUpRequest(userId, password);
        String requestBody = objectMapper.writeValueAsString(signUpRequest);
        mockMvc.perform(post("/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        User user = userRepository.findByUserId(userId);
        Assertions.assertNotNull(user);
    }

    @DisplayName("로그인 - 성공")
    @Test
    void signIn() throws Exception{
        userService.join(new SignUpRequest(userId, password));
        SignInRequest signInRequest = new SignInRequest(userId, password);
        String requestBody = objectMapper.writeValueAsString(signInRequest);
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.header().exists("Authorization"));
    }
}
