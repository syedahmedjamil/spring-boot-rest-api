package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.example.demo.service.TokenService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/token")
public class TokenController {
    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping(path = "registration")
    public String getToken() {
        return tokenService.getToken();
    }

    @GetMapping(path = "access")
    public String getAccessToken() {
        return tokenService.getAccessToken();
    }

    @PostMapping(path = "registration")
    public void storeToken(@Valid @NotNull @RequestBody String token) {
        tokenService.storeToken(token);
    }

}
