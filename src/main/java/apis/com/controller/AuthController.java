package apis.com.controller;
 

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.com.config.JwtService;
import apis.com.dto.LoginUserDto;
import apis.com.dto.UserRequestDto;
import apis.com.dto.UserResponseDto;
import apis.com.entities.User;
import apis.com.response.LoginResponse;
import apis.com.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	private final JwtService jwtService; 
    private final AuthService authService;
    
    
    public AuthController(JwtService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto userRequestDTO) {
        User user = authService.signup(userRequestDTO);
        UserResponseDto userResponseDTO = new UserResponseDto(user);
        return ResponseEntity.ok(userResponseDTO);
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authService.authenticate(loginUserDto); 
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
    
   
}
