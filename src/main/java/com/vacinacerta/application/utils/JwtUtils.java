package com.vacinacerta.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JwtUtils {

    public Claims getJwtClaims(String token) {
        return Jwts.parser()
                .setSigningKey("key")
                .parseClaimsJwt(token)
                .getBody();
    }

    public boolean validateJwtClaims(Claims claims) {
        LocalDateTime localDateTime = LocalDateTime.now();

        Instant instant = localDateTime.toInstant(ZoneId.of("America/Sao_Paulo").getRules().getOffset(localDateTime));

        Date dateNow = Date.from(instant);

        if(claims.getExpiration().before(dateNow)) {
            return false;
        }

        return true;
    }
}
