package stone.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import stone.spring.models.Signup;

public interface SignupRepository extends JpaRepository<Signup, Long> {

	List<Signup> findByLastName(String lastName);

	List<Signup> findByFirstName(String firstName);
}
