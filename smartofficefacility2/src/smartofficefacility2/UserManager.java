package smartofficefacility2;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
	private Map<String, User> users;

    public UserManager() {
        users = new HashMap<>();
        // Add some default users
        users.put("admin", new User("admin", "password123"));
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.validatePassword(password);
    }

}
