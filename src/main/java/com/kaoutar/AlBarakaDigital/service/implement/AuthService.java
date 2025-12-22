package com.kaoutar.AlBarakaDigital.service.implement;

import com.kaoutar.AlBarakaDigital.dto.CreateUserDTO;
import com.kaoutar.AlBarakaDigital.enums.RoleUser;
import com.kaoutar.AlBarakaDigital.mapper.UserMapper;
import com.kaoutar.AlBarakaDigital.model.User;
import com.kaoutar.AlBarakaDigital.repository.UserRepository;
import com.kaoutar.AlBarakaDigital.security.JWT.JWT;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder; // ✅ Import correct
import org.springframework.stereotype.Service;
import com.kaoutar.AlBarakaDigital.dto.LoginRequestDTO;
import com.kaoutar.AlBarakaDigital.dto.JwtResponseDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder; // ✅ Interface Spring Security
    private final AuthenticationManager authenticationManager;
    private final JWT jwtService;

    public void register(CreateUserDTO req){
        if(userRepository.existsByEmail(req.getEmail())){
            throw new RuntimeException("Email déjà utilisé");
        }

        User user = userMapper.createUserDTOToUser(req);
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setRole(RoleUser.ROLE_Admin);

        userRepository.save(user); // ✅ Sauvegarde dans la base de données
    }

    public JwtResponseDTO login(LoginRequestDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        return new JwtResponseDTO(token);
    }
}