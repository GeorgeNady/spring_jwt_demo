package com.george.spring_jwt_demo.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureGenerationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * <h3>we just graphing the information that already coming with the <span color="yellow">request</span> { <span color="green">username</span>, <span color="green">password</span> }</h3>
     * <h3>then pass it into <span color="green">UsernamePasswordAuthenticationToken</span></h3>
     * <h3>then we call the <span color="green">AuthenticationManager</span> to authenticate the user who trying to login here with this <span color="yellow">request</span> </h3>
     * <h2>if we want the user to pass ith the body as as <span color="blue">JSON OBJECT</span> we can user <span color="blue">ObjectMapper</span> to grab the information we need</h2>
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(@NotNull HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("Username is: {}", username);
        log.info("Password is: {}", password);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,password);
        log.info("token is: {}", token);
        return authenticationManager.authenticate(token);
    }

    /**
     * <h1>Used to do something when user successfully authenticated</h1>
     * @param request
     * @param response
     * @param chain
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, @NotNull Authentication authentication) throws IOException, ServletException {
        // this is the suer that coming from `UserDetails`
        // this `Principal` is the user who has been successfully authenticated
        User user = (User) authentication.getPrincipal();
        // from `auth0 jwt library`
        // this is the declaration of the algorithm that we used to sign a signed json web token and the refresh token
        Algorithm algorithm = Algorithm.HMAC256("secret_key".getBytes());
        String access_token = JWT.create()
                // subject can be any string that we want { userId, username, email }
                // or any something unique about the user, so we can identify the user by that specific token
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + (10 * 60 + 1000)))
                // the issuer can be { company name, or the author of this token }
                .withIssuer(request.getRequestURI().toString())
                // the claims are all the role for that specific user,
                // so we have to pass tha 1-{name of the claim} 2-{and the list of some sorts witch is contains all claims}
                // "roles": is the name that we gave as the key to that list of roles
                // and on the other hand we pass the list of the authorities that will be the claims of that user
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        String refresh_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + (30 * 60 + 1000)))
                .withIssuer(request.getRequestURI())
                .sign(algorithm);

        // then we pass it with response header to the front end :)
        response.setHeader("access_token",access_token);
        response.setHeader("refresh_token",refresh_token);
    }

    /**
     * <h1>Used if we want to do something if user authentication was unsuccessful</h1>
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);

    }
}
