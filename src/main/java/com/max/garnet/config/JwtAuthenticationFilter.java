package com.max.garnet.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.max.garnet.service.CustomUserDetailsService;
import com.max.garnet.service.JWTService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
    private JWTService jwtService; // Service xử lý JWT

    @Autowired
    private CustomUserDetailsService customUserDetailsService; // Service lấy thông tin User từ database

    
	
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
    	// 1. Lấy JWT từ header Authorization
    	final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userName;
        
       // Log để kiểm tra Authorization header
        System.out.println("Authorization Header: " + authHeader);
        
        
       if(StringUtils.hasText(authHeader) || !StringUtils.startsWithIgnoreCase(authHeader,"Bearer ")){
            filterChain.doFilter(request,response);// Không có JWT, bỏ qua filter
            return;
        }
       
        jwt = authHeader.substring(7);//trích xuất jwt từ header
        userName = jwtService.extractUserName(jwt);
        
        // Log để kiểm tra token đã trích xuất
        System.out.println("JWT Token: " + jwt);
        // Log để kiểm tra email người dùng được trích xuất từ token
        System.out.println("Extracted User Name: " + userName);
        
        
        
        if(StringUtils.hasText(userName)&& SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);
            

            if (jwtService.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken token = 
                    new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                    );

                // Sử dụng WebAuthenticationDetailsSource để gắn thêm thông tin chi tiết
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Thiết lập Authentication vào SecurityContext
                SecurityContextHolder.getContext().setAuthentication(token);
            }
        }
        filterChain.doFilter(request,response);
    }


    
    
}

