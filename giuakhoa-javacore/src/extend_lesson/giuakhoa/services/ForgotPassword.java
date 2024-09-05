package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;
import java.util.List;
import java.util.Scanner;

public class ForgotPassword {
    private List<User> users;
    private Scanner scanner;

    public ForgotPassword(List<User> users, Scanner scanner) {
        this.users = users;
        this.scanner = scanner;
    }

    public User execute() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                System.out.print("New Password: ");
                String newPassword = scanner.nextLine();
                user.setPassword(newPassword);
                System.out.println("Đổi mật khẩu thành công. Vui lòng đăng nhập lại.");
                return new LogIn(users, scanner).execute();
            }
        }
        System.out.println("Email không tồn tại.");
        return null;
    }
}








