package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;

import java.util.Scanner;
public class ChangeEmail {
    private UserService userService;

    private Scanner scanner;
    private User user;

    public ChangeEmail(UserService userService, Scanner scanner, User user) {
        this.userService = userService;
        this.scanner = scanner;
        this.user = user;
    }
    public void execute(){

        System.out.println("nhập email mới:");
        String newEmail = scanner.nextLine();
        if (userService.changeEmail(user.getUsername(), newEmail)){
            System.out.println("Đổi email thành công.");
        }else {
            System.out.println("Email đã tồn tại hoặc không hợp lệ.");

        }
    }
}
