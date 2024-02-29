package com.example.demo.doa;

import com.example.demo.model.Person;

import java.util.List;
import java.util.UUID;

public interface TokenDao {
    String getToken();

    void storeToken(String token);

    String getAccessToken();
}
