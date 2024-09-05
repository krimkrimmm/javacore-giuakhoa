package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
public class ChangeEmail {
    private List<User> users;
    private Scanner scanner;

    public ChangeEmail(List<User> users, Scanner scanner) {
        this.users = users;
        this.scanner = scanner;
    }

    public void execute(User user) {
        System.out.print("New Email: ");
        String newEmail = scanner.nextLine();

        if (!isValidEmail(newEmail)) {
            System.out.println("Email không hợp lệ.");
            return;
        }

        if (isEmailTaken(newEmail)) {
            System.out.println("Email đã tồn tại.");
            return;
        }

        user.setEmail(newEmail);
        System.out.println("Đổi email thành công.");
    }

    private boolean isEmailTaken(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }
}



