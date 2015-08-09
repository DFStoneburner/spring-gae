package stone.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stone.spring.models.Signup;
import stone.spring.repositories.SignupRepository;

@Service
public class SignupService {

	@Autowired
	private SignupRepository signupRepository;

	public void add(final Signup signup) {
		signupRepository.save(signup);
	}

	public List<Signup> findAll() {
		return signupRepository.findAll();
	}

	public void deleteAll() {
		signupRepository.deleteAllInBatch();
	}

	public List<Signup> findAllByLastName(String lastName) {
		return signupRepository.findByLastName(lastName);
	}
}
