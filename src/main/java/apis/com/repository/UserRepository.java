package apis.com.repository;
 
 

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import apis.com.entities.User;
import apis.com.enums.Role;

public interface UserRepository extends JpaRepository<User, Long>{ 
	Optional<User> findByEmail(String email);
	List<User> findByRoleNot(Role role);
}
