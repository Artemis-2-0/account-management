package com.brihaspathee.artemis.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, June 2022
 * Time: 10:55 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.auth
 * To change this template use File | Settings | File and Code Template
 */
@Component
public class JwtUtil {

    private String SECRET_KEY = "secret";

    /**
     * Uses extractClaim method to get the username from the token
     * @param token
     * @return
     */
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * User extractClaim method to get the expiration date of the token
     * @param token
     * @return
     */
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Takes the toke and uses claims resolver to figure out the claims associated with the user
     * This is used by other methods to extract the username, token expiration date etc
     * @param token
     * @param claimsResolver
     * @param <T>
     * @return
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extract all the claims that are associated with the token
     * @param token
     * @return
     */
    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Checks if the token is expired
     * @param token
     * @return
     */
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    /**
     * This method takes the user details object provided by user details service class
     * and creates a token using the createToken method
     * The empty claims are passed
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    /**
     * The create token method will create an Jwt token using HS256 algorithm and the secret key
     * It also the sets the user as the subject and an expiry time for the token along with the
     * date and time the token is issued
     * @param claims
     * @param subject
     * @return
     */
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }

    /**
     * The validateToken method extracts the username from the token and compares it with the user details returned
     * from the service and that the token is not expired
     * @param token
     * @param userDetails
     * @return
     */
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
