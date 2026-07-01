package com.sanya.car_rental_backend.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    // Secret Key (Keep this secret)
    private static final String SECRET =
            "ThisIsMySecretKeyForCarRentalProjectJwtAuthentication2026";

    // Convert String Secret into Key
    private static final Key KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    // Token Validity (24 Hours)
    private static final long EXPIRATION =
            1000 * 60 * 60 * 24;

    // Generate JWT
    public static String generateToken(String email) {

        return Jwts.builder()

                .setSubject(email)

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(
                                System.currentTimeMillis() + EXPIRATION
                        )
                )

                .signWith(
                        KEY,
                        SignatureAlgorithm.HS256
                )

                .compact();

    }

    // Extract Email
    public static String extractUsername(String token) {

        return getClaims(token).getSubject();

    }

    // Check Expiration
    public static boolean isTokenExpired(String token) {

        return getClaims(token)

                .getExpiration()

                .before(new Date());

    }

    // Validate Token
    public static boolean validateToken(String token, String email) {

        return extractUsername(token).equals(email)

                &&

                !isTokenExpired(token);

    }

    // Read Claims
    private static Claims getClaims(String token) {

        return Jwts.parser()

                .setSigningKey(KEY)

                .build()

                .parseClaimsJws(token)

                .getBody();

    }




}//package com.sanya.car_rental_backend.Security;
//
//import io.jsonwebtoken.Jwts;
//
//import io.jsonwebtoken.security.Keys;
//
//import javax.crypto.SecretKey;
//
//import java.util.Date;
//
//    public class JwtUtil {
//
//        private static final SecretKey key=
//
//                Keys.secretKeyFor(
//                        io.jsonwebtoken
//                                .SignatureAlgorithm
//                                .HS256
//                );
//
//
//        public static String generateToken(
//                String email
//        ){
//
//            return Jwts.builder()
//
//                    .subject(email)
//
//                    .issuedAt(
//                            new Date()
//                    )
//
//                    .expiration(
//                            new Date(
//                                    System.currentTimeMillis()
//                                            +
//                                            86400000
//                            )
//                    )
//
//                    .signWith(key)
//
//                    .compact();
//
//        }
//        public static boolean validateToken(
//                String token
//        ){
//
//            try{
//
//                Jwts.parser()
//
//                        .verifyWith(key)
//
//                        .build()
//
//                        .parseSignedClaims(token);
//
//                return true;
//
//            }catch(Exception e){
//
//                return false;
//
//            }
//
//        }
//
//    }
