package apis.com.impl;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import apis.com.dto.LoginUserDto;
import apis.com.dto.UserRequestDto;
import apis.com.entities.User;
import apis.com.enums.Role; 
import apis.com.repository.UserRepository;
import apis.com.service.AuthService;

@Service
public class AuthImpl implements AuthService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;

	
	
	@Override
	public User signup(UserRequestDto  userRequestDto) {  
        String encodedPassword = passwordEncoder.encode(userRequestDto.getPassword()); 
        User user = new User();
        user.setFullName(userRequestDto.getFullName())
            .setProfileTitle(userRequestDto.getProfileTitle())
            .setEmail(userRequestDto.getEmail())
            .setPassword(encodedPassword)
            .setRole(Role.CANDIDATE); 
        return userRepository.save(user);
	}
	
	@Override
	public User authenticate(LoginUserDto input) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
		return userRepository.findByEmail(input.getEmail()).orElseThrow();
	}
	
	
}
