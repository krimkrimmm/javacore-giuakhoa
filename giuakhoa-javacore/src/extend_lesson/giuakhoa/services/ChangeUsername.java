package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;
import  java.util.List;
import java.util.Scanner;
public class ChangeUsername {
    private List<User> users;
    private Scanner scanner;

    public ChangeUsername(List<User> users, Scanner scanner) {
        this.users = users;
        this.scanner = scanner;
    }

    public void execute(User currentUser) {
        System.out.print("New Username: ");
        String newUsername = scanner.nextLine();

        if (isUsernameTaken(newUsername)) {
            System.out.println("Username đã tồn tại.");
            return;
        }

        currentUser.setUsername(newUsername);
        System.out.println("Đổi username thành công.");
    }

    private boolean isUsernameTaken(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}




