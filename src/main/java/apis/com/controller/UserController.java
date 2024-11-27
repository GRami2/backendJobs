package apis.com.controller;
 
 
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;

import apis.com.config.JwtService;
import apis.com.dto.UserRequestDto;
import apis.com.dto.UserResponseDto;
import apis.com.entities.User; 
import apis.com.service.UserService; 

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 
    private final UserService userService;
    
    
    public UserController(JwtService jwtService, UserService userService) { 
        this.userService = userService;
    } 
    
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> getAll() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDto> userResponseDTOs = users.stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userResponseDTOs);
    }
    
    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> getCurrentUser(Principal principal) { 
        String email = principal.getName(); 
        User user = userService.findByEmail(email); 
        UserResponseDto userResponseDTO = new UserResponseDto(user);
        return ResponseEntity.ok(userResponseDTO);
    } 

    @PutMapping("/update")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDTO) {
        User user = userService.updateUser(id, userRequestDTO);
        UserResponseDto userResponseDTO = new UserResponseDto(user);
        return ResponseEntity.ok(userResponseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}