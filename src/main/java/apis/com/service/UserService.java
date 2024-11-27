package apis.com.service;

import java.util.List; 
 
import apis.com.dto.UserRequestDto;
import apis.com.entities.User;

public interface UserService { 
	
	
	public User updateUser(Long id, UserRequestDto userRequestDTO);
	public void deleteUser(long id);  
	public List<User> getAllUsers(); 
	public User findByEmail(String email);
	

} 