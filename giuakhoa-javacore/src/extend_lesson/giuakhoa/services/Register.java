package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Register {
    private List<User> users;
    private Scanner scanner;

    public Register(List<User> users, Scanner scanner) {
        this.users = users;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        if (findUserByUsername(username) != null) {
            System.out.println("Username đã tồn tại.");
            return;
        }

        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", email) || findUserByEmail(email) != null) {
            System.out.println("Email không hợp lệ hoặc đã tồn tại.");
            return;
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (!Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[.,-_]).{7,15}$", password)) {
            System.out.println("Password không hợp lệ.");
            return;
        }

        users.add(new User(username, email, password));
        System.out.println("Đăng ký thành công.");
    }
    private User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    private User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
