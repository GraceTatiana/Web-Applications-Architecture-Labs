package waa.lab6.restful.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import waa.lab6.restful.entity.dto.versioning.User;
import waa.lab6.restful.repo.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found") );

        return UserPrincipal.builder()
          .id(user.getId())
          .email(user.getEmail())
          .password(user.getPassword())
          .roles(user.getRoles())
          .build();
    }
}
