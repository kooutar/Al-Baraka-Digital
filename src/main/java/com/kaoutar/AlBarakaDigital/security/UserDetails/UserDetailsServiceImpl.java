package com.kaoutar.AlBarakaDigital.security.UserDetails;

import com.kaoutar.AlBarakaDigital.mapper.UserMapper;
import com.kaoutar.AlBarakaDigital.model.User;
import com.kaoutar.AlBarakaDigital.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepo;
    private UserMapper mapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
        return new UserDetailsImpl(mapper.userToCreateUserDTO(user));
    }
}
