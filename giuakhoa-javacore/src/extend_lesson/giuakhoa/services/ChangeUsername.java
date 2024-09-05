package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;

import java.util.Scanner;
public class ChangeUsername {
    private UserService userService;

    private Scanner scanner;
    private User user;

    public ChangeUsername(UserService userService, Scanner scanner, User user) {
        this.userService = userService;
        this.scanner = scanner;
        this.user = user;
    }

    public void execute() {

        System.out.println("nhập username mới:");
        String newUsername = scanner.nextLine();
        if (userService.changeUsername(user.getUsername(), newUsername)) {
            System.out.println("đổi username thành công.");
        } else {
            System.out.println("Username đã tồn tại hoặc không hợp lệ.");
        }
    }

}
