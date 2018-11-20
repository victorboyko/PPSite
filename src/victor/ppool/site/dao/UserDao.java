package victor.ppool.site.dao;

import victor.ppool.site.model.User;

public interface UserDao {

	void save(User user);
	User get(String login, String password);
	
}
