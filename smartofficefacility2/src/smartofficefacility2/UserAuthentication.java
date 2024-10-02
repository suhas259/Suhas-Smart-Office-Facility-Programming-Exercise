package smartofficefacility2;
import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {
	private static Map<String, String> users;

    static {
        users = new HashMap<>();
        // Predefined users: username => password
        users.put("admin", "admin123");
        users.put("user", "user123");
    }

    public static boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

}
