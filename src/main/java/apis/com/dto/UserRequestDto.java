package apis.com.dto;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserRequestDto {
	 	private String fullName;
	    private String profileTitle;
	    private String email;
	    private String password; 
}
