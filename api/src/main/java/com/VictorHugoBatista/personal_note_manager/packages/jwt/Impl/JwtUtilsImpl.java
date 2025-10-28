package com.VictorHugoBatista.personal_note_manager.packages.jwt.Impl;

import java.security.NoSuchAlgorithmException;

import com.VictorHugoBatista.personal_note_manager.packages.jwt.JwtUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class JwtUtilsImpl implements JwtUtils {
    private final Algorithm algorithm;

    private static JwtUtils instance;

    public static JwtUtils getInstance() throws NoSuchAlgorithmException {
        if (instance == null) {
            instance = new JwtUtilsImpl();
        }

        return instance;
    }

    @Override
    public String create(String userId) throws JWTCreationException {
        return JWT.create()
            .withIssuer("auth0")
            .withSubject(userId)
            .sign(algorithm);
    }

    @Override
    public String validate(String token) {
        return JWT.require(algorithm)
                .withIssuer("auth0")
                .build()
                .verify(token)
                .getSubject();
    }

    private JwtUtilsImpl() throws NoSuchAlgorithmException {
        algorithm = Algorithm.HMAC256("teste-teste");
    }
}
