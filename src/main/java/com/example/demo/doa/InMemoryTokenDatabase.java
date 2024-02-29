package com.example.demo.doa;

import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

@Repository("InMemoryTokenDatabase")
public class InMemoryTokenDatabase implements TokenDao {
    private String token = "no token stored";

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void storeToken(String token) {
        this.token = token;
    }

    @Override
    public String getAccessToken() {
        GoogleCredentials googleCredentials = null;
        try {
            googleCredentials = GoogleCredentials
                    .fromStream(new FileInputStream("service-account.json"))
                    .createScoped(List.of("https://www.googleapis.com/auth/firebase.messaging"));
            googleCredentials.refresh();
        } catch (Exception e) {
            return e.getMessage();
        }

        return googleCredentials.getAccessToken().getTokenValue();
    }
}
