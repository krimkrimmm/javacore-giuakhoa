package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;
import java.util.List;
import java.util.Scanner;
public class LogIn {
    private List<User> users;

    private Scanner scanner;
    public LogIn(List<User> users, Scanner scanner) {
        this.users = users;
        this.scanner = scanner;
    }
    public User execute() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    System.out.println("Chào mừng " + username + ", bạn có thể thực hiện các công việc sau:");
                    return user;
                } else {
                    System.out.println("Sai mật khẩu.");
                    System.out.println("1 - Đăng nhập lại");
                    System.out.println("2 - Quên mật khẩu");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1) {
                        return execute();
                    } else if (choice == 2) {
                        return new ForgotPassword(users, scanner).execute();
                    }
                }
            }
        }
        System.out.println("Kiểm tra lại username");
        return execute();
    }
}