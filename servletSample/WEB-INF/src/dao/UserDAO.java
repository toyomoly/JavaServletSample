package dao;

import dto.User;

public class UserDAO {

	public User findByUserName(String userName) {

		User user = new User("hanako", "password", "HANAKO");

		return user;
	}
}
