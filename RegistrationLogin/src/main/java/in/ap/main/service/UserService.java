package in.ap.main.service;

import in.ap.main.entity.User;

public interface UserService {
	public boolean registerUser(User user);
	public User loginUser(String email, String password)
	;

}
