package com.kaoutar.AlBarakaDigital.service.implement;

import com.kaoutar.AlBarakaDigital.model.User;
import com.kaoutar.AlBarakaDigital.repository.UserRepository;
import com.kaoutar.AlBarakaDigital.security.AuthenticatedUser.AuthenticatedUserService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticatedUserService authService;

    public User getCurrentUser()  {
        String email = authService.getEmail();
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Utilisateur non trouvé"));
    }



}
