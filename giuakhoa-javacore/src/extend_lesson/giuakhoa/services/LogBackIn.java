package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;
import java.util.List;
import java.util.Scanner;
public class LogBackIn {
    private List<User> users;
    private Scanner scanner;

    public LogBackIn(List<User> users, Scanner scanner) {
        this.users = users;
        this.scanner = scanner;
    }

    public User execute() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Chào mừng " + username + ", bạn có thể thực hiện các công việc sau:");
                return user;
            }
        }
        System.out.println("Sai username hoặc mật khẩu.");
        return null;
    }
}
