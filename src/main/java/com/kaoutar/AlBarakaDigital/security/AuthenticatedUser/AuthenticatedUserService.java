package com.kaoutar.AlBarakaDigital.security.AuthenticatedUser;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUserService {
    public UserDetails getUserDetails()  {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null || !authentication.isAuthenticated()){
            throw  new RuntimeException("Utilisateur  non authentifié");
        }

        return (UserDetails) authentication.getPrincipal();
    }

    public  String getEmail()   {
        return  getUserDetails().getUsername();
    }
}
