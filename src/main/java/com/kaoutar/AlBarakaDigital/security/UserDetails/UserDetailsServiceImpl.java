package com.kaoutar.AlBarakaDigital.security.UserDetails;

import com.kaoutar.AlBarakaDigital.mapper.UserMapper;
import com.kaoutar.AlBarakaDigital.model.User;
import com.kaoutar.AlBarakaDigital.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepo;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable avec l'email : " + username));
        return new UserDetailsImpl(mapper.userToCreateUserDTO(user));
    }
}
