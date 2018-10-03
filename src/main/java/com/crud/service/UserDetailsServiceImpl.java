package com.crud.service;

import com.crud.service.abstraction.UserService;
import com.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getByLogin(login);

        UserBuilder builder = null;
        if (user != null) {
            String[] roles = {user.getRole()};
            builder = org.springframework.security.core.userdetails.User.withUsername(user.getLogin());
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.roles(roles);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }

}
