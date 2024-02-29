package com.example.demo.service;

import com.example.demo.doa.PersonDao;
import com.example.demo.doa.TokenDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TokenService {
    private final TokenDao tokenDao;

    @Autowired
    public TokenService(@Qualifier("InMemoryTokenDatabase") TokenDao tokenDao) {

        this.tokenDao = tokenDao;
    }

    public String getToken() {
        return tokenDao.getToken();
    }

    public void storeToken(String token) {
        tokenDao.storeToken(token);
    }

    public String getAccessToken() {
        return tokenDao.getAccessToken();
    }
}
