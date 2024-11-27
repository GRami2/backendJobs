package apis.com.service;
 

import apis.com.dto.LoginUserDto;
import apis.com.dto.UserRequestDto;
import apis.com.entities.User;

public interface AuthService {
	public User signup(UserRequestDto userRequestDTO);
	public User authenticate(LoginUserDto data);
	
}
