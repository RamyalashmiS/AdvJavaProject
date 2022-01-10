package proj.persist.user;

import proj.entity.users.User;

public interface UserDAO {
	public void insertUser(User user);

	public User readUser(User user);

	public User updateUser(User user,String password);

	public void deleteUser(User user);

}
