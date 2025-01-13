package in.ap.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ap.main.entity.User;
import in.ap.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public boolean registerUser(User user) {

		try {
			repository.save(user);
			return true;
		} catch (Exception a) {
			a.printStackTrace();
			return false;
		}

	}

	@Override
	public User loginUser(String email, String password) {
		// TODO Auto-generated method stub
		User validUser = repository.findByEmail(email);
		if(validUser != null && validUser.getPassword().equals(password))
		{
			return validUser;
		}
		return null;
	}
}
