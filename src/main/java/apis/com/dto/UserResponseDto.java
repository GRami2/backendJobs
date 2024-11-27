package apis.com.dto;

import java.util.Date;

import apis.com.entities.User;
import apis.com.enums.Role;
import lombok.Data; 
  
@Data
public class UserResponseDto {
    private Long id;
    private String fullName;
    private String profileTitle;
    private String email;
    private Role role;
    private Date createdAt;
    private Date updatedAt;
    
    public UserResponseDto(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.profileTitle = user.getProfileTitle();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}	
