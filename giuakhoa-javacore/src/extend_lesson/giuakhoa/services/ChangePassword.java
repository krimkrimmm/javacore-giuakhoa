package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;
import java.util.List;
import java.util.Scanner;
public class ChangePassword {


    private Scanner scanner;
    private List<User>users;
    public ChangePassword(Scanner scanner) {
        this.scanner = scanner;
        this.users= users;
    }
    public void execute(User user) {
        System.out.print("New Password: ");
        String newPassword = scanner.nextLine();
        user.setPassword(newPassword);
        System.out.println("Đổi mật khẩu thành công.");
    }
}
