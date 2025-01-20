package com.hub.foro.security;

import lombok.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class TokenService {


        @Value("${jwt.secret}")
        private String secret;

        @Value("${jwt.expiration}")
        private String expiration;

        public String generateToken(Authentication authentication) {
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + Long.parseLong(expiration));

            return Jwts.builder()
                    .setIssuer("API Forum")
                    .setSubject(authentication.getName())
                    .setIssuedAt(new Date())
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();
        }

        public boolean isTokenValid(String token) {
            try {
                Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public String getUsernameFromToken(String token) {
            return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody().getSubject();
        }
    }


