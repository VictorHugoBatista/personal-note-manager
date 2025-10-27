package com.VictorHugoBatista.personal_note_manager.common.filters;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.VictorHugoBatista.personal_note_manager.packages.jwt.Impl.JwtUtilsImpl;
import com.VictorHugoBatista.personal_note_manager.users.v1.model.User;
import com.VictorHugoBatista.personal_note_manager.users.v1.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        try {
            var token = this.recoverToken(request);

            if (token != null) {
                var jwtUtils = JwtUtilsImpl.getInstance();
                var userId = jwtUtils.validate(token);
                User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
                var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
                var authentication = new UsernamePasswordAuthenticationToken(user.getOpenData(), null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
