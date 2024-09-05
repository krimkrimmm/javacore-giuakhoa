package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;
import java.util.ArrayList;
import java.util.regex.Pattern;
public class UserService {
    private ArrayList<User> users = new ArrayList<>();

    public boolean register(String username, String email, String password) {
        if (users.stream().anyMatch(user -> user.getUsername().equals(username) || user.getEmail().equals(email))) {
            return false;
        }
        if (!validateEmail(email) || !validatePassword(password)) {
            return false;
        }
        users.add(new User(username, email, password));
        return true;
    }
    public User login(String username, String password) {
        return users.stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).findFirst().orElse(null);
    }
    public boolean changeUsername(String oldUsername, String newUsername) {
        if (users.stream().anyMatch(user -> user.getUsername().equals(newUsername))) {
            return false;
        }
        User user = users.stream().filter(u -> u.getUsername().equals(oldUsername)).findFirst().orElse(null);
        if (user != null) {
            user.setUsername(newUsername);
            return true;
        }
        return false;
    }
    public boolean changeEmail(String username, String newEmail) {
        if (!validateEmail(newEmail) || users.stream().anyMatch(user -> user.getEmail().equals(newEmail))) {
            return false;
        }
        User user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
        if (user != null) {
            user.setEmail(newEmail);
            return true;
        }
        return false;
    }

    public boolean changePassword(String username, String newPassword) {
        if (!validatePassword(newPassword)) {
            return false;
        }
        User user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
        if (user != null) {
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    public boolean resetPassword(String email, String newPassword) {

        User user = users.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
        if (user != null && validatePassword(newPassword)) {
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    private boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        return Pattern.matches(regex, email);
    }

    private boolean validatePassword(String password) {
        return password.length() >= 7 && password.length() <= 15 &&
                password.chars().anyMatch(Character::isUpperCase) &&
                password.chars().anyMatch(ch -> ".-_;".indexOf(ch) >= 0);
    }
}












