package com.VictorHugoBatista.personal_note_manager.users.v1.jwt.Impl;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import com.VictorHugoBatista.personal_note_manager.users.v1.jwt.JwtUtils;
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
    public String create(Map<String, ?> data) throws JWTCreationException {
        return JWT.create()
            .withIssuer("auth0")
            .withPayload(data)
            .sign(algorithm);
    }

    private JwtUtilsImpl() throws NoSuchAlgorithmException {
        var keyGenerator = KeyPairGenerator.getInstance("RSA");
		keyGenerator.initialize(1024);

		var kp = keyGenerator.genKeyPair();
		var publicKey = (RSAPublicKey) kp.getPublic();
		var privateKey = (RSAPrivateKey) kp.getPrivate();
        algorithm = Algorithm.RSA256(publicKey, privateKey);
    }
}
