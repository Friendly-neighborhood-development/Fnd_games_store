package com.fnd.games_store.test.jwt_utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fnd.games_store.login.LoginApplication;
import com.fnd.games_store.login.jwt_utils.JwtGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = LoginApplication.class)
public class GenerateJwtToken_UnitTest {

    @Autowired
    private JwtGenerator jwtGenerator;

    private String referenceToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY3MTEyMzU1MywiaWF0IjoxNjcxMDMzNTUzfQ._IDSuEOf6ie6ds9qHqwuBOEVRyikEp3fJ9hn6rUiQhs";


    @Test
    void generateJwtToken_ShouldReturnTokenWithSpecifiedUsername(){
        assertThat(getUsernameFromToken(generateTestToken(generateUserDetails("admin")))).isEqualTo(getUsernameFromToken(referenceToken));
    }

    private UserDetails generateUserDetails(String username){
        List<GrantedAuthority> adminGrantedAuthorities = new ArrayList<>();

        return new User(username,
                "",
                true,
                true,
                true,
                true,
                adminGrantedAuthorities);
    }



    private String generateTestToken(UserDetails userDetails){
        return jwtGenerator.generateJwtToken(generateUserDetails("admin"));
    }

    private String getUsernameFromToken(String token) {
        return parseToken(token).getSubject();
    }

    private DecodedJWT parseToken(String token) {
        return JWT.decode(token);
    }


}
