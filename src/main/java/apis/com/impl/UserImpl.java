package apis.com.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
 
import apis.com.dto.UserRequestDto;
import apis.com.entities.User;
import apis.com.enums.Role;
import apis.com.repository.UserRepository;
import apis.com.service.UserService;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
 
 
	@Override
	public User updateUser(Long id, UserRequestDto userRequestDTO) {
		User existingUser = userRepository.findById(id).get();
		existingUser.setFullName(userRequestDTO.getFullName());
		existingUser.setProfileTitle(userRequestDTO.getProfileTitle());
		existingUser.setEmail(userRequestDTO.getEmail()); 
		if (userRequestDTO.getPassword() != null && !userRequestDTO.getPassword().isEmpty()) {
			existingUser.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
		}
		return userRepository.save(existingUser);
	}
 

	@Override
	public void deleteUser(long id) {
		if (!userRepository.existsById(id)) {
			throw new RuntimeException("User with ID " + id + " does not exist");
		}
		userRepository.deleteById(id);
	} 

	@Override
	public List<User> getAllUsers() {
		return userRepository.findByRoleNot(Role.ADMIN);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
	}

}
